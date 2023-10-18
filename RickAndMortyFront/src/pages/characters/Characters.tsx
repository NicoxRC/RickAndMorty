import Cards from '../../components/cards/Cards';
import Filter from '../../components/filter/Filter';
import Pagination from '../../components/pagination/Pagination';
import SearchBar from '../../components/searchBar/SearchBar';
import Footer from '../../components/footer/Footer';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getAllCharacters } from '../../slices/characterSlice';
import { filtersEnum } from '../../types/filter';
import type { AppDispatch, RootState } from '../../app/store';
import type { CharactersInterface } from '../../interfaces/characters';

export default function Characters(): JSX.Element {
  const dispatch: AppDispatch = useDispatch();
  const allCharacters = useSelector<RootState, CharactersInterface[]>(
    (state) => state.characters.characters
  );

  useEffect(() => {
    dispatch(getAllCharacters());
  }, [dispatch]);
  useEffect(() => {
    console.log(allCharacters);
  }, [allCharacters]);

  return (
    <div>
      <div className="d-flex justify-content-evenly">
        <div>
          <SearchBar />
        </div>
        <div className="d-flex">
          <Filter filterType={filtersEnum.Gender} />
          <Filter filterType={filtersEnum.Species} />
          <Filter filterType={filtersEnum.Status} />
          <div className="w-25">
            <Filter filterType={filtersEnum.Type} />
          </div>
        </div>
      </div>
      <Cards />
      <Pagination />
      <Footer />
    </div>
  );
}
