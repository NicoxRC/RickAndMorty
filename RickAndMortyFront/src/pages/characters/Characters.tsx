import Cards from '../../components/cards/Cards';
import NavBar from '../../components/navBar/NavBar';
import Pagination from '../../components/pagination/Pagination';
import SearchBar from '../../components/searchBar/SearchBar';

export default function Characters() {
  return (
    <div>
      <NavBar />
      <SearchBar />
      <Cards />
      <Pagination />
    </div>
  );
}
