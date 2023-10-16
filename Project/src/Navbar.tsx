import { useEffect } from 'react';
import { NavLink, Route, Routes } from "react-router-dom";
import Homepage from "./Pages/Homepage/homepage.tsx";
import Projects from "./Pages/Projects/projects.tsx";
import Friends from "./Pages/Friends/friends.tsx";
import Collection from "./Pages/Collection/Collection.tsx";
import gsap from 'gsap';
import clickSound from '/sounds/Tab.mp3';

export default function Navbar() {
    const MAX_TRANSLATION = 20; // Adjust this value as needed

    useEffect(() => {
      const handleScroll = () => {
        const navbar = document.querySelector('.navbar');
        const scrollY = window.scrollY;
        const translation = -Math.min(scrollY * 1.2, MAX_TRANSLATION); // Limit the translation
  
        gsap.to(navbar, {

          y: translation,
          duration: 0.01,
          ease: 'power2.out',
        });
      };      
  
      window.addEventListener('scroll', handleScroll);
      return () => {
        window.removeEventListener('scroll', handleScroll);
      };
    }, []);

     // Function to play the click sound
   const playClickSound = () => {
    const audio = new Audio(clickSound);
    audio.play();
  };


    return (
    <>
     <div className="main-container">
      <nav className="navbar">
        <ul className="nav-list">
          <li className="nav-item">
            <NavLink onClick={playClickSound} to="/" className={(navData) => (navData.isActive ? "Nactive" : 'none')} >
              Home
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink onClick={playClickSound} to="/projects" className={(navData) => (navData.isActive ? "Nactive" : 'none')}>
              Projects
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink onClick={playClickSound} to="/collection" className={(navData) => (navData.isActive ? "Nactive" : 'none')}>
              Collection
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink onClick={playClickSound} to="/friends" className={(navData) => (navData.isActive ? "Nactive" : 'none')}>
              Friends
            </NavLink>
          </li>
        </ul>
      </nav>
      
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="projects" element={<Projects />} />
        <Route path="/Collection" element={<Collection />} />
        <Route path="friends" element={<Friends />} />
      </Routes>
      </div>
    </>
   
  );
}
