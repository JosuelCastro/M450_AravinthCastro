import React, { useState, useEffect } from 'react';
import './homepage.css';
import Grid from '@mui/material/Grid';
import InfiniteLooper from './InfiniteLooper';
// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-ignore
import Portrait from './Portrait.svelte?in-react';
const getRandomSentence = () => {
    const sentences = [
        'Welcome to my website!',
        'Check out my projects!',
        'Learn more about me!',
        'Enjoy your stay!',
        'Explore my skills!',
        'Yay!',
        'Goppenstein',
        // Add more sentences
    ];

    const randomIndex = Math.floor(Math.random() * sentences.length);
    return sentences[randomIndex];
};

// Retro-style skill icons (you can replace them with your own icons)
const skills = [
  { name: 'Web Development', icon: '🕹️' },
    { name: 'UI/UX Design', icon: '💾' },
  { name: 'Filmography', icon: '🎥' },


  // Add more skills
];

const Home: React.FC = () => {
    const [scrollSpeed, setScrollSpeed] = useState(8);
    const [randomSentence] = useState(getRandomSentence());

    useEffect(() => {
        const handleScroll = () => {
            const scrollY = window.scrollY;

            // Define a base speed that increases with scrolling
            const baseSpeed = 8;


            // Calculate adjusted speeds based on scrolling
            const adjustedSpeed = baseSpeed + scrollY * 0.5;


            setScrollSpeed(adjustedSpeed);

        };

        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    return (
        <Grid container spacing={2}>
            <Grid item xs={12}>
                <InfiniteLooper speed={scrollSpeed} direction="left">
                    <h1 className="name">Josuel Castro</h1>
                </InfiniteLooper>
                <InfiniteLooper speed={scrollSpeed} direction="right">
                    <h1 className="name">{randomSentence}</h1>
                </InfiniteLooper>
            </Grid>
            <Grid item xs={12}>
                <Grid container spacing={2}>
                    <Grid item xs={2}/>
                    <Grid item xs={2}>
                        <Portrait/>
                    </Grid>
                    {/* Self Introduction */}
                    <Grid item xs={6}>

                        <div className="self-introduction">
                            <h2 className="self-introduction-heading">Hi, I'm Josuel Castro</h2>
                            <p className="self-introduction-text">
                                This is a short Portfolio about myself.
                            </p>
                        </div>
                    </Grid>
                </Grid>
            </Grid>
            <Grid item xs={12}>
                <div className="skills-container">
                    <h2 className="skills-heading">Skills</h2>
                    <div className="skills-list">
                        {skills.map(skill => (
                            <Grid item xs={3} key={skill.name}>
                                <div className="skill-item">
                                    <span className="skill-icon">{skill.icon}</span>
                                    <span className="skill-name">{skill.name}</span>
                                </div>
                            </Grid>
                        ))}
                    </div>
                </div>
            </Grid>
        </Grid>
    );
};

    export default Home;
