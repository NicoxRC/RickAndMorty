import { Routes, Route } from 'react-router-dom';
import Home from './pages/home/Home';
import CharacterDetails from './pages/characterDetails/characterDetails';
import NewCharacter from './pages/newCharacter/NewCharacter';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/details" element={<CharacterDetails />} />
        <Route path="/newCharacter" element={<NewCharacter />} />
      </Routes>
    </div>
  );
}

export default App;
