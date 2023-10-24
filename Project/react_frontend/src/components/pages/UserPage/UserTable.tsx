import React, {useContext, useEffect, useState} from 'react';
import {
    Card,
    Button,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    TablePagination,
} from '@mui/material';
import { useNavigate } from 'react-router-dom';
import UserService from '../../../Services/UserService';
import { User } from '../../../types/models/User.model';
import activeUserContext from "../../../Contexts/ActiveUserContext";
import ActiveUserContext from "../../../Contexts/ActiveUserContext";

const UserTable = () => {
    const activeUserContext = useContext(ActiveUserContext);
    const navigate = useNavigate();
    const [users, setUsers] = useState<User[]>([]);
    const [page, setPage] = useState(0);
    const rowsPerPage = 5;

    useEffect(() => {
        // Fetch users with pagination parameters
        loadUsers(page);
    }, [page]);

    const loadUsers = (currentPage: number) => {
        UserService.getAllUsers(currentPage, rowsPerPage)
            .then((data) => {
                setUsers(data);
            })
            .catch((error) => {
                console.error('Error fetching users:', error);
            });
    };

    const handleAdd = () => {
        navigate('../useradd');
    };

    const handleDelete = (id: string | undefined) => {
        // Check if the user to delete is the same as the currently logged-in user
        const loggedInUserId = activeUserContext.user?.id;
        if (id === loggedInUserId) {
            // Display an alert if the user is trying to delete their own account
            alert("You can't delete your own account.");
            return;
        }

        // Continue with the deletion if it's not the logged-in user's account
        UserService.deleteUser(id)
            .then(() => {
                // After deleting, fetch the updated user list
                loadUsers(page);
            })
            .catch((error) => {
                console.error('Error deleting user:', error);
            });
    };

    const handleChangePage = (event: unknown, newPage: number) => {
        setPage(newPage);
    };

    const handleLoadMore = () => {
        // Increment the page to load the next set of users
        setPage(page + 1);
    };

    return (
        <>
            <TableContainer component={Card}>
                <Table aria-label='User Table'>
                    <TableHead>
                        <TableRow>
                            <TableCell>Username</TableCell>
                            <TableCell>Email</TableCell>
                            <TableCell>Address</TableCell>
                            <TableCell>Birthdate</TableCell>
                            <TableCell>Actions</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users.map((user) => (
                            <TableRow key={user.id}>
                                <TableCell>{user.username}</TableCell>
                                <TableCell>{user.email}</TableCell>
                                <TableCell>{user.profile?.address || 'No profile created yet'}</TableCell>
                                <TableCell>{user.profile?.birthdate || 'No profile created yet'}</TableCell>
                                <TableCell>
                                    <Button
                                        size='small'
                                        color='error'
                                        variant='contained'
                                        onClick={() => {
                                            handleDelete(user.id);
                                        }}
                                    >
                                        Delete
                                    </Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>

                </Table>
            </TableContainer>
            <TablePagination
                component='div'
                count={users.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
            />
            <Button size='small' color='success' variant='contained' onClick={handleAdd}>
                Add
            </Button>
            <Button
                size='small'
                color='primary'
                variant='contained'
                onClick={handleLoadMore}
                disabled={users.length < rowsPerPage}
            >
                Load More
            </Button>
        </>
    );
};

export default UserTable;
