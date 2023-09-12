import React, { useState } from 'react';
import { useGLTF, Stage, OrbitControls } from '@react-three/drei';
import { Canvas } from '@react-three/fiber';
import './CharacterCard.css';

interface CharacterCardProps {
    name: string;
    height: string;
    favoriteAnimal: string;
    strength: number;
    intelligence: number;
    humor: number;
    style: number,
    description: string;
    sound: string;
    modelPath: string;
}

const Model: React.FC<{ url: string }> = ({ url }) => {
    const { scene } = useGLTF(url);
    // Modify the rotation of the scene
    scene.rotation.y = Math.PI / 4; // Adjust the rotation angle as needed
    return <primitive object={scene} />;
};

const CharacterCard: React.FC<CharacterCardProps> = ({ name, height, favoriteAnimal, strength, intelligence, humor, style, description, sound, modelPath }) => {
    const [isSelected, setIsSelected] = useState(false);
    const [controlsEnabled, setControlsEnabled] = useState(false);

    const playSound = () => {
        const audio = new Audio(sound);
        audio.play();
    };

    const toggleCard = () => {
        if (!isSelected) {
            playSound();
        }
        setIsSelected(!isSelected);
        setControlsEnabled(!controlsEnabled);
    };

    const canvasStyle = {
        height: isSelected ? '300px' : '100px', // Adjust the height based on selection
        width: isSelected ? '900px' : '100px',
    };

    return (
        <div className={`character-card ${isSelected ? 'selected' : ''}`}>
            <div className="character-container">
                <div className="character-model" style={canvasStyle}>
                    <Canvas dpr={[1, 2]} shadows camera={{ fov: 45 }}>
                        <Stage>
                            <Model url={modelPath} />
                            <OrbitControls enableZoom={true} maxDistance={5} enabled={controlsEnabled} />
                        </Stage>
                    </Canvas>
                </div>
                <div className={`character-info ${isSelected ? 'expanded' : ''}`}>
                    <div className={`info-top ${isSelected ? 'expanded' : ''}`}>
                        <h3 className={`character-name ${isSelected ? 'expanded' : ''}`}>{name}</h3>
                        {!isSelected && (<p className={`character-description ${isSelected ? 'expanded' : ''}`}>{description}</p>)}
                        {isSelected && (
                            <>
                                <p><strong>Height:</strong> {height}</p>
                                <p><strong>Favorite Animal:</strong> {favoriteAnimal}</p>
                                <div className="strength-bar-container">
                                    <div className="strength-bar-group">
                                        <p className="status-bar"><strong>Strength:</strong></p>
                                        <div className="strength-bar">
                                            <div className="strength-fill" style={{ width: `${strength}%` }}></div>
                                        </div>
                                    </div>
                                    <div className="strength-bar-group">
                                        <p className="status-bar"><strong>Intelligence:</strong></p>
                                        <div className="strength-bar">
                                            <div className="strength-fill" style={{ width: `${intelligence}%` }}></div>
                                        </div>
                                    </div>
                                </div>
                                <div className="strength-bar-container">
                                    <div className="strength-bar-group">
                                        <p className="status-bar"><strong>Humor:</strong></p>
                                        <div className="strength-bar">
                                            <div className="strength-fill" style={{ width: `${humor}%` }}></div>
                                        </div>
                                    </div>
                                    <div className="strength-bar-group">
                                        <p className="status-bar"><strong>Style:</strong></p>
                                        <div className="strength-bar">
                                            <div className="strength-fill" style={{ width: `${style}%` }}></div>
                                        </div>
                                    </div>
                                </div>

                            </>
                        )}
                    </div>
                </div>
                <button className={`RetroButton select-button ${isSelected ? 'selected' : ''}`} onClick={toggleCard}>
                    {isSelected ? 'Deselect' : 'Select'}
                </button>

            </div>
        </div>
    );
};

export default CharacterCard;
