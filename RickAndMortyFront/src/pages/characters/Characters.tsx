import Cards from '../../components/cards/Cards';
import Filter from '../../components/filter/Filter';
import Pagination from '../../components/pagination/Pagination';
import SearchBar from '../../components/searchBar/SearchBar';
import Footer from '../../components/footer/Footer';
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { getAllCharacters } from '../../slices/characterSlice';
import { FiltersEnum } from '../../types/filter';
import type { AppDispatch } from '../../app/store';

export default function Characters(): JSX.Element {
  const dispatch: AppDispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllCharacters());
  }, [dispatch]);

  return (
    <div>
      <div className="d-flex justify-content-evenly">
        <div>
          <SearchBar />
        </div>
        <div className="d-flex">
          <Filter filterType={FiltersEnum.Gender} />
          <Filter filterType={FiltersEnum.Species} />
          <Filter filterType={FiltersEnum.Status} />
          <div className="w-25">
            <Filter filterType={FiltersEnum.Type} />
          </div>
        </div>
      </div>
      <Cards />
      <Pagination />
      <Footer />
    </div>
  );
}
