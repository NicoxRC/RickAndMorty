import { filtersEnum } from '../../utils/filterType';
import Cards from '../../components/cards/Cards';
import Filter from '../../components/filter/Filter';
import NavBar from '../../components/navBar/NavBar';
import Pagination from '../../components/pagination/Pagination';
import SearchBar from '../../components/searchBar/SearchBar';
import Footer from '../../components/footer/Footer';

export default function Characters(): JSX.Element {
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
