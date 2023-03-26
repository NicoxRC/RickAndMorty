import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { characterApiName } from '../../services/charactersApiName';
import { setCurrentPage, url } from '../../slices/paginationSlice';

export default function SearchBar(): JSX.Element {
  const dispatch = useDispatch();
  const [name, setName] = useState<string>('');

  const handleSearchInput = async (e: React.FormEvent<HTMLInputElement>) => {
    setName(e.currentTarget.value);
  };

  const handleSubmit = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    const res = await characterApiName(name);
    if (typeof res === 'string') {
      dispatch(url(res));
      dispatch(setCurrentPage(1));
    }
  };

  return (
    <form className="d-flex w-75 m-2" role="search">
      <input
        className="form-control me-2 w-25"
        placeholder="Search"
        type="search"
        onChange={handleSearchInput}
      />
      <button
        className="btn btn-outline-success"
        type="submit"
        onClick={handleSubmit}
      >
        Search
      </button>
    </form>
  );
}
