import { filtersEnum } from '../../utils/filterType';
import Cards from '../../components/cards/Cards';
import Filter from '../../components/filter/Filter';
import NavBar from '../../components/navBar/NavBar';
import Pagination from '../../components/pagination/Pagination';
import SearchBar from '../../components/searchBar/SearchBar';
import Footer from '../../components/footer/Footer';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import type { AppDispatch, RootState } from '../../app/store';
import { getAllCharacters } from '../../slices/characterSlice';
import { RickAndMortyApiInterface } from '../../utils/rickAndMortyApiInterface';

export default function Characters(): JSX.Element {
  const dispatch: AppDispatch = useDispatch();
  const allCharacters = useSelector<RootState, RickAndMortyApiInterface[]>(
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
      <NavBar />
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
