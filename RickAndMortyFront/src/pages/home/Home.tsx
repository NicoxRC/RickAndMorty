import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import Cards from '../../components/cards/Cards';
import NavBar from '../../components/navBar/NavBar';
import { getCharactersApi } from '../../slices/characterSlice';

export default function Home() {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getCharactersApi());
  }, [dispatch]);

  return (
    <div>
      <NavBar />
      <Cards />
    </div>
  );
}
