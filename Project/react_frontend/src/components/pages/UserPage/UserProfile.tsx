import React, { useContext, useEffect, useState } from 'react';
import {
    Card,
    CardContent,
    CardActions,
    Button,
    TextField,
    Typography,
    Grid,
    Box,
    Paper,
    Avatar,
    Container,
    Modal,
    Fade,
} from '@mui/material';
import UserService from '../../../Services/UserService';
import ActiveUserContext from '../../../Contexts/ActiveUserContext';
import { User } from '../../../types/models/User.model';

const UserProfile = () => {
    const activeUserContext = useContext(ActiveUserContext);

    // State for edit mode
    const [isEditing, setIsEditing] = useState(false);

    // State for the modal
    const [openModal, setOpenModal] = useState(false);

    // State for the new URL with a default value of an empty string
    const [newPicURL, setNewPicURL] = useState(activeUserContext.user?.profile?.profilePicture || 'https://upload.wikimedia.org/wikipedia/en/thumb/a/a9/MarioNSMBUDeluxe.png/220px-MarioNSMBUDeluxe.png');

    // Function to handle changes to user data
    const handleUserDataChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        // Get the current user from the context
        const currentUser = activeUserContext.user as User;

        // Create a new User object with updated data
        const updatedUser: User = {
            ...currentUser,
            [name]: value,
        };

        // Update the user data in the ActiveUserContext
        activeUserContext.setActiveUser(updatedUser);
    };
    const handleUserProfileDataChange = (event: React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
        const { name, value } = event.target;
        // Get the current user from the context
        const currentUser = activeUserContext.user as User;

        // Create a new User object with updated data
        const updatedUser: User = {
            ...currentUser,
            profile: {
                ...currentUser.profile,
                [name]: value,
            },
        };

        // Update the user data in the ActiveUserContext
        activeUserContext.setActiveUser(updatedUser);
    };

    // Function to handle opening the modal
    const handleOpenModal = () => {
        setOpenModal(true);
    };

    // Function to handle closing the modal
    const handleCloseModal = () => {
        setOpenModal(false);
    };

    // Function to handle changing the URL

    const handleSaveChanges = () => {
        // Create a copy of the user's profile
        const updatedProfile = { ...user?.profile };

        // Update individual fields in the profile as needed
        updatedProfile.address = user?.profile.address; // Assuming user.address is the updated address value
        updatedProfile.birthdate = user?.profile.birthdate; // Assuming user.birthdate is the updated birthdate value
        updatedProfile.profilePicture = newPicURL;

        // Create a copy of the user with the updated profile
        const updatedUserData = {
            ...user,
            profile: updatedProfile,

        };

        // Update the user data in the ActiveUserContext
        activeUserContext.setActiveUser(updatedUserData);

        // Send the updated user data to the server using the UserService
        UserService.updateUser(updatedUserData)
            .then((updatedUser) => {
                // Handle success, if needed
                console.log('User data updated on the server:', updatedUser);
            })
            .catch((error) => {
                // Handle errors, if needed
                console.error('Error updating user data:', error);
            });

        // Set isEditing to false after saving
        setIsEditing(false);
    };

    // Use the active user data from the ActiveUserContext
    const user = activeUserContext.user;

    useEffect(() => {
        console.log('UserProfile component mounted');
        activeUserContext.loadActiveUser();

        const userId = activeUserContext.user?.id;
        if (userId) {
            console.log('Fetching user data for userId:', userId);
            UserService.getUserByID(userId)
                .then((userData) => {
                    if (userData) {
                        console.log('User data loaded:', userData);
                        // Update the user data in the ActiveUserContext
                        activeUserContext.setActiveUser(userData);
                    }
                })
                .catch((error) => {
                    // Handle errors if necessary
                    console.error('Error fetching user data:', error);
                });
        }
    }, []);


    return (
        <Container maxWidth="md">
            <Paper elevation={3}>
                <Box p={3}>
                    <Typography variant="h5" component="div">
                        User Profile
                    </Typography>
                    <Grid container spacing={2}>
                        <Grid item xs={12} md={6}>
                            <Card>
                                <CardContent>
                                    <Avatar
                                        alt="User Avatar"
                                        src={user?.profile?.profilePicture || "https://upload.wikimedia.org/wikipedia/en/thumb/a/a9/MarioNSMBUDeluxe.png/220px-MarioNSMBUDeluxe.png"}
                                        sx={{ width: 150, height: 150 }}
                                        onClick={handleOpenModal}
                                        style={{ cursor: 'pointer' }}
                                    />
                                </CardContent>
                            </Card>
                        </Grid>
                        <Grid item xs={12} md={6}>
                            <form>
                                <Grid container spacing={2}>
                                    <Grid item xs={6}>
                                        <TextField
                                            fullWidth
                                            label="Username"
                                            name="username"
                                            value={user?.username || ''}
                                            onChange={handleUserDataChange}
                                            disabled={!isEditing}
                                        />
                                    </Grid>
                                    <Grid item xs={6}>
                                        <TextField
                                            fullWidth
                                            label="Email"
                                            name="email"
                                            value={user?.email || ''}
                                            onChange={handleUserDataChange}
                                            disabled={!isEditing}
                                        />
                                    </Grid>
                                    <Grid item xs={12}>
                                        <TextField
                                            fullWidth
                                            label="Address"
                                            name="address"
                                            defaultValue={user?.profile?.address || ''}
                                            onChange={handleUserProfileDataChange}
                                            disabled={!isEditing}
                                        />
                                    </Grid>
                                    <Grid item xs={6}>
                                        <TextField
                                            fullWidth
                                            label="Birthdate"
                                            name="birthdate"
                                            defaultValue={user?.profile?.birthdate || ''}
                                            onChange={handleUserProfileDataChange}
                                            disabled={!isEditing}
                                        />
                                    </Grid>
                                    <Grid item xs={12}>
                                        <TextField
                                            fullWidth
                                            label="Password"
                                            name="password"
                                            type="password"
                                            defaultValue={user?.password || ''}
                                            onChange={handleUserDataChange}
                                            disabled={!isEditing}
                                        />
                                    </Grid>
                                </Grid>
                            </form>
                        </Grid>
                    </Grid>
                    <CardActions>
                        {isEditing ? (
                            <Button onClick={handleSaveChanges}>Save</Button>
                        ) : (
                            <Button onClick={() => setIsEditing(true)}>Edit</Button>
                        )}
                    </CardActions>
                </Box>
            </Paper>
            <Modal
                open={openModal}
                onClose={handleCloseModal}
                aria-labelledby="modal-title"
                aria-describedby="modal-description"
                closeAfterTransition
                style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center',
                }}
            >
                <Fade in={openModal}>
                    <div
                        className="modal-content"
                        style={{
                            backgroundColor: 'white',
                            width: '300px',
                            padding: '20px',
                            borderRadius: '5px',
                            textAlign: 'center',
                        }}
                    >
                        <h2 id="modal-title">Change Profile Picture URL</h2>
                        <TextField
                            fullWidth
                            label="New URL"
                            name="profilePicture"
                            defaultValue={newPicURL}
                            onChange={(event)=>{setNewPicURL(event.target.value);handleUserProfileDataChange(event)}}
                            style={{ marginBottom: '10px' }}
                        />
                        <Button
                            variant="contained"
                            style={{ marginRight: '10px' }}
                            onClick={() => setOpenModal(false)}
                        >
                            Save
                        </Button>
                        <Button
                            onClick={handleCloseModal}
                            variant="contained"
                            color="secondary"
                        >
                            Cancel
                        </Button>
                    </div>
                </Fade>
            </Modal>
        </Container>
    );
};

export default UserProfile;
