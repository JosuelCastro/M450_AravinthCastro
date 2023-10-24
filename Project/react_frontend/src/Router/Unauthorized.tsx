import React from 'react';
import { Container, Typography, Box } from '@mui/material';

const UnauthorizedPage = () => {
    return (
        <Container>
            <Box
                display="flex"
                flexDirection="column"
                alignItems="center"
                justifyContent="center"
                height="80vh"
            >
                <Typography variant="h4" gutterBottom>
                    YOU CAN'T ACCESS THIS
                </Typography>
                <img src={"https://media.istockphoto.com/id/1064654202/photo/human-hand-showing-stop-sign.jpg?s=612x612&w=0&k=20&c=0pUA0xhDU6wm5cFIHGC0we9-Z1Z4_svz07vFRJ13Z-4="} alt="Unauthorized" width="300" height="300" />
            </Box>
        </Container>
    );
};

export default UnauthorizedPage;
