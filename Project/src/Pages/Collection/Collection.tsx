import React, { useEffect, useState } from 'react';
import './Collection.css';

const Collection: React.FC = () => {
    const [position, setPosition] = useState({ x: 0, y: 0 });
    const boxSize = 300; // Adjust the size of the box

    useEffect(() => {
        const handleKeyPress = (event: KeyboardEvent) => {
            const speed = 10;

            let newX = position.x;
            let newY = position.y;

            if (event.key === 'w' && newY - speed >= 0) {
                newY -= speed;
            } else if (event.key === 's' && newY + speed <= boxSize - 50) {
                newY += speed;
            } else if (event.key === 'a' && newX - speed >= 0) {
                newX -= speed;
            } else if (event.key === 'd' && newX + speed <= boxSize - 50) {
                newX += speed;
            }

            setPosition({ x: newX, y: newY });
        };

        window.addEventListener('keydown', handleKeyPress);

        return () => {
            window.removeEventListener('keydown', handleKeyPress);
        };
    }, [position, boxSize]);

    return (
        <div style={{
           
            width: '100vw',
            height: '100vh',
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center'
        }}>
            <div style={{ border: '2px solid white', width: `${boxSize}px`, height: `${boxSize}px`, position: 'relative' }}>
                <div className="box" style={{ left: position.x, top: position.y }}></div>
            </div>
        </div>
    );
};

export default Collection;
