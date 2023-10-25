import { Routes, Route } from 'react-router-dom';
import Characters from './pages/characters/Characters';
import CharacterDetails from './pages/characterDetails/characterDetails';
import NewCharacter from './pages/newCharacter/NewCharacter';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import NavBar from './components/navBar/NavBar';

function App(): JSX.Element {
  return (
    <div className="App">
      <NavBar />
      <Routes>
        <Route path="/" element={<Characters />} />
        <Route path="/details" element={<CharacterDetails />} />
        <Route path="/newCharacter" element={<NewCharacter />} />
      </Routes>
    </div>
  );
}

export default App;
