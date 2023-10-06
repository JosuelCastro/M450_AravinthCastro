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

const skills = [
    { name: 'Web Development', icon: '🕹️' },
    { name: 'UI/UX Design', icon: '💾' },
    { name: 'Filmography', icon: '🎥' },
    // Add more skills
];

const calculateTimeDifference = () => {
    const birthday = new Date('2006-02-05T12:01:00Z');
    const currentTime = new Date();

    const diff = currentTime.getTime() - birthday.getTime();

    const diffInSeconds = diff / 1000;
    const years = Math.floor(diffInSeconds / (60 * 60 * 24 * 365.25));
    const days = Math.floor((diffInSeconds % (60 * 60 * 24 * 365.25)) / (60 * 60 * 24));
    const hours = Math.floor((diffInSeconds % (60 * 60 * 24)) / (60 * 60));
    const minutes = Math.floor((diffInSeconds % (60 * 60)) / 60);
    const seconds = Math.floor(diffInSeconds % 60);

    return { years, days, hours, minutes, seconds };
};

const Home: React.FC = () => {
    const [scrollSpeed, setScrollSpeed] = useState(8);
    const [randomSentence] = useState(getRandomSentence());
    const [age, setAge] = useState(calculateTimeDifference());

    useEffect(() => {
        const handleScroll = () => {
            const scrollY = window.scrollY;
            const baseSpeed = 8;
            const adjustedSpeed = baseSpeed + scrollY * 0.5;
            setScrollSpeed(adjustedSpeed);
        };

        const intervalId = setInterval(() => {
            setAge(calculateTimeDifference());
        }, 1000); // Update every second

        window.addEventListener('scroll', handleScroll);

        return () => {
            clearInterval(intervalId);
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
                <Grid container spacing={2} >
                    <Grid item lg={4} md={5} xs={12} sx={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                        <div className="portrait-container">
                            <Portrait className="portrait" />
                        </div>
                    </Grid>
                    <Grid item lg={8} md={7} xs={12}>
                        <div style={{ border: "2px solid white"}}>
                        <div style={{ border: "2px solid black"}}>
                            <div className="self-introduction">
                            <h2 className="self-introduction-heading">Hi, I'm Josuel</h2>
                            <p className="self-introduction-text">
                                This is a short Portfolio about myself. I'm <span>{age.years}</span> years <span>{age.days}</span> days <span>{age.hours}</span> hours  <span>{age.minutes}</span> minutes  (and <span>{age.seconds}</span> seconds old). I love expressing myself in various ways. Perhaps the things I do aren't for everyone, but at least they're the way I do it.<p>Always stay true to yourself</p>
                            </p>
                        </div>
                        </div>
                        </div>
                    </Grid>
                </Grid>
            </Grid>
            <Grid item xs={12}>
                <div className="skills-container">
                    <h2 className="skills-heading">Skills</h2>
                    <div className="skills-list">
                        {skills.map((skill) => (
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
