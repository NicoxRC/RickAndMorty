import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getCharactersApi } from '../../slices/characterSlice';

export default function Home() {
  const dispatch = useDispatch();
  const characters = useSelector(
    (state: any) => state.characters.charactersApi
  );

  useEffect(() => {
    dispatch(getCharactersApi());
  }, [dispatch]);

  return (
    <div>
      <button onClick={() => console.log(characters)}>hola que hace</button>
    </div>
  );
}
