import React from 'react';
import CharacterCard from './CharacterCard';

const characters = [
    {
        name: 'Danny',
        description: 'Certified Goppensteiner',
        height: '6\'0"',
        favoriteAnimal: 'Cat',
        strength: 31,
        intelligence: 37,
        humor: 34,
        style: 21,
        sound: '/sounds/Danny.mp3',
        modelPath: '/models/Danny.glb'
    },
    {
        name: 'Orcun',
        description: 'So Soll Es Sein',
        height: '6\'2"',
        favoriteAnimal: 'Pinguin',
        strength: 12,
        intelligence: 31,
        humor: 3,
        style: 7,
        sound: '/sounds/Orcun.m4a',
        modelPath: '/models/Orcun.glb'
    },
    {
        name: 'Harald',
        description: 'Goppennein Aktivist',
        height: '5\'9"',
        favoriteAnimal: 'Lamm',
        strength: 100,
        intelligence: 100,
        humor: 100,
        style: 100,
        sound: '/sounds/HaraldMueller.mp3',
        modelPath: '/models/Harald.glb'
    },
    {
        name: 'Noel',
        description: 'Not the Nerd',
        height: '5\'9"',
        favoriteAnimal: 'Dog',
        strength: 38,
        intelligence: 9,
        humor: 57,
        style: 2,
        sound: '/sounds/Noel.m4a',
        modelPath: '/models/Noel.glb'
    },
    {
        name: 'Luca',
        description: 'The American',
        height: '5\'11"',
        favoriteAnimal: 'Owl',
        strength: 49,
        intelligence: 31,
        humor: 3,
        style: 42,
        sound: '/sounds/Luca.m4a',
        modelPath: '/models/Luca.glb'
    },
    {
        name: 'Aryan',
        description: 'Memento Mori',
        height: '5\'7"',
        favoriteAnimal: 'Capybara',
        strength: 72,
        intelligence: 5,
        humor: 54,
        style: 81,
        sound: '/sounds/Aryan.m4a',
        modelPath: '/models/Aryan.glb'
    },
    {
        name: 'Joao',
        description: 'The big Short',
        height: '5\'5"',
        favoriteAnimal: 'dog (my mom)',
        strength: 77,
        intelligence: 82,
        humor: 15,
        style: 46,
        sound: '/sounds/Joao.m4a',
        modelPath: '/models/Joao.glb'
    },
    {
        name: 'Hendrik',
        description: 'The Heretic',
        height: '5\'9"',
        favoriteAnimal: 'Fish',
        strength: 17,
        intelligence: 7,
        humor: 50,
        style: 13,
        sound: '/sounds/Hendrik.m4a',
        modelPath: '/models/Hendrik.glb'
    },
    {
        name: 'Motty',
        description: 'Motventurer',
        height: '5\'11"',
        favoriteAnimal: 'Owl',
        strength: 52,
        intelligence: 99,
        humor: 56,
        style: 9,
        sound: '/sounds/Motty.m4a',
        modelPath: '/models/Motty.glb'
    },
    {
        name: 'Mischa',
        description: 'Cool Man',
        height: '6\'0"',
        favoriteAnimal: 'Deer',
        strength: 29,
        intelligence: 59,
        humor: 81,
        style: 97,
        sound: '/sounds/Mischa.m4a',
        modelPath: '/models/Mischa.glb'
    },
    // Add more characters here
];

const Friends: React.FC = () => {
    return (
        <div className="character-selection">
            {characters.map((character, index) => (
                <CharacterCard
                    key={index}
                    name={character.name}
                    description={character.description}
                    height={character.height}
                    favoriteAnimal={character.favoriteAnimal}
                    strength={character.strength}
                    intelligence={character.intelligence}
                    humor={character.humor}
                    style={character.style}
                    sound={character.sound}
                    modelPath={character.modelPath}
                />
            ))}
        </div>
    );
};

export default Friends;
