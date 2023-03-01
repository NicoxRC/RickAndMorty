import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import Cards from '../../components/cards/Cards';
import NavBar from '../../components/navBar/NavBar';
import Pagination from '../../components/pagination/Pagination';
import { getCharactersApi } from '../../slices/characterSlice';

export default function Characters() {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getCharactersApi());
  }, [dispatch]);

  return (
    <div>
      <NavBar />
      <Cards />
      <Pagination />
    </div>
  );
}
