import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { characterApiName } from '../../services/charactersApiName';
import { showCharacters } from '../../slices/characterSlice';

export default function SearchBar() {
  const dispatch = useDispatch();
  const [name, setName] = useState('');

  const handleSearchInput = async (e: React.FormEvent<HTMLInputElement>) => {
    setName(e.currentTarget.value);
  };

  const handleSubmit = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    const response = await characterApiName(name);
    if (response?.results.length > 0) {
      dispatch(showCharacters(response.results));
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
