import React from 'react';
import { Box, Typography, Button } from '@mui/material';
import logo from "../../logo1.png";

export default function HomePage() {
  return (
      <Box
          display='flex'
          flexDirection='column'
          alignItems='center'
          justifyContent='center'
          minHeight='70vh'
          padding={2}
      >
        <img
            src={logo}
            alt='Logo'
            style={{ maxWidth: '200px', filter: 'invert(100%)' }}
        />
        <Typography variant='h3' component='h1' gutterBottom>
          Welcome to OurCool Website
        </Typography>
        <Typography variant='body1' paragraph>
          Website made by Aryan Aravinth and Josuel Castro
        </Typography>
        <Button variant='contained' color='primary' href='/userprofile'>
          Get Started
        </Button>
      </Box>
  );
}
