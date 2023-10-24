import React from 'react';
import { useFormik } from 'formik';
import { Box, Button, TextField, Typography } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { object, string } from 'yup';
import UserService from '../../../Services/UserService';
import { User } from '../../../types/models/User.model';

interface UserProps {
    user: User;
    submitActionHandler: (values: User) => void;
}

const UserForm = ({ user, submitActionHandler }: UserProps) => {
    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            id: '',
            username: '',
            profile: { address: '', id: '', profilePicture: '', birthdate: '' },
            email: '',
            password: '',
            roles: [],
        },
        validationSchema: object({
            username: string().required('Username is required').min(2).max(50),
            email: string().required('Email is required').email('Invalid email'),
            password: string().required('Password is required').min(4, 'Password must be at least 4 characters'),
        }),
        onSubmit: async (values: User) => {
            try {
                const newUser = await UserService.registerUser(values);
                // Handle successful registration (e.g., show a success message)
                alert('User registered');
            } catch (error) {
                // Handle registration error (e.g., display an error message)
                alert('Error registering user');
            }
        },
    });

    return (
        <Box sx={{ maxWidth: 400, margin: '0 auto' }}>
            <Typography variant="h5" gutterBottom>
                User Registration
            </Typography>
            <form onSubmit={formik.handleSubmit}>
                <TextField
                    id="username"
                    label="Username"
                    variant="outlined"
                    fullWidth
                    sx={{ marginBottom: 2 }}
                    onBlur={formik.handleBlur}
                    onChange={formik.handleChange}
                    error={Boolean(formik.touched.username && formik.errors.username)}
                    value={formik.values.username}
                    helperText={formik.touched.username && formik.errors.username}
                />

                <TextField
                    id="email"
                    label="E-Mail"
                    variant="outlined"
                    fullWidth
                    sx={{ marginBottom: 2 }}
                    onBlur={formik.handleBlur}
                    onChange={formik.handleChange}
                    error={Boolean(formik.touched.email && formik.errors.email)}
                    value={formik.values.email}
                    helperText={formik.touched.email && formik.errors.email}
                />

                <TextField
                    id="password"
                    label="Password"
                    type="password"
                    variant="outlined"
                    fullWidth
                    sx={{ marginBottom: 2 }}
                    onBlur={formik.handleBlur}
                    onChange={formik.handleChange}
                    error={Boolean(formik.touched.password && formik.errors.password)}
                    value={formik.values.password}
                    helperText={formik.touched.password && formik.errors.password}
                />

                <Button
                    variant="contained"
                    color="primary"
                    type="submit"
                    fullWidth
                    disabled={!(formik.dirty && formik.isValid)}
                    sx={{ marginTop: 2 }}
                >
                    Register
                </Button>

                <Button
                    variant="contained"
                    color="error"
                    fullWidth
                    onClick={() => {
                        navigate('/users');
                    }}
                    sx={{ marginTop: 1 }}
                >
                    Cancel
                </Button>
            </form>
        </Box>
    );
};

export default UserForm;
