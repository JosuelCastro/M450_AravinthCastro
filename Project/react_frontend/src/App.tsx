import React from 'react';
import Navbar from "./components/organisms/Navbar";
import './App.css';

import { ActiveUserContextProvider } from './Contexts/ActiveUserContext';
import Router from './Router/Router';

function App() {
  return (
    <ActiveUserContextProvider>
        <Navbar/>
      <Router/>
    </ActiveUserContextProvider>
  );
}

export default App;
