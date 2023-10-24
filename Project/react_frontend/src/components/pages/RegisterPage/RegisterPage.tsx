import React from 'react';
import { useFormik } from 'formik';
import { User } from '../../../types/models/User.model';
import { Box, Button, Card, CardContent, CardHeader, TextField, Typography, Container } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { object, string } from 'yup';
import UserService from '../../../Services/UserService';

const RegisterPage = () => {
    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            id: '',
            username: '',
            profile: { address: '', id: '', profilePicture: '', birthdate: '' },
            email: '',
            password: '',
            roles: []
        },
        validationSchema: object({
            username: string().required().min(2).max(50),
            email: string().required().email(),
            // Add validation for other properties
        }),
        onSubmit: async (values: User) => {
            try {
                const newUser = await UserService.registerUser(values);
                navigate("/")
                // Handle successful registration (e.g., show a success message)
                alert('User registered');
            } catch (error) {
                // Handle registration error (e.g., display an error message)
                alert('Error registering user');
            }
        },
    });

    return (
        <Container
            sx={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '80vh',
            }}
        >
            <Card>
                <CardHeader title="Register" />
                <CardContent>
                    <form onSubmit={formik.handleSubmit}>
                        <Box sx={{ paddingTop: '15px' }}>
                            <TextField
                                id='username'
                                label='Username'
                                variant='outlined'
                                sx={{ marginBottom: '10px' }}
                                onBlur={formik.handleBlur}
                                onChange={formik.handleChange}
                                error={Boolean(formik.touched.username && formik.errors.username)}
                                value={formik.values.username}
                                fullWidth
                            />
                            {formik.errors.username && formik.touched.username ? (
                                <Typography variant="body2" color="error">
                                    {formik.errors.username}
                                </Typography>
                            ) : null}
                            <TextField
                                id='email'
                                label='E-Mail'
                                variant='outlined'
                                sx={{ marginBottom: '10px' }}
                                onBlur={formik.handleBlur}
                                onChange={formik.handleChange}
                                error={Boolean(formik.touched.email && formik.errors.email)}
                                value={formik.values.email}
                                fullWidth
                            />
                            {formik.errors.email && formik.touched.email ? (
                                <Typography variant="body2" color="error">
                                    {formik.errors.email}
                                </Typography>
                            ) : null}
                            <TextField
                                id='password'
                                label='Password'
                                variant='outlined'
                                sx={{ marginBottom: '10px' }}
                                onBlur={formik.handleBlur}
                                onChange={formik.handleChange}
                                error={Boolean(formik.touched.password && formik.errors.password)}
                                value={formik.values.password}
                                fullWidth
                                type="password"
                            />
                            {formik.errors.password && formik.touched.password ? (
                                <Typography variant="body2" color="error">
                                    {formik.errors.password}
                                </Typography>
                            ) : null}
                        </Box>
                        <Button
                            variant='contained'
                            color='success'
                            type='submit'
                            disabled={!(formik.dirty && formik.isValid)}
                        >
                            Register
                        </Button>
                        <Button
                            variant='contained'
                            color='error'
                            onClick={() => {
                                navigate('/users');
                            }}
                        >
                            Cancel
                        </Button>
                    </form>
                </CardContent>
            </Card>
        </Container>
    );
};

export default RegisterPage;
