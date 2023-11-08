import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { characterApiName } from '../../services/charactersApiName';
import { setCurrentPage } from '../../slices/paginationSlice';

export default function SearchBar(): JSX.Element {
  const dispatch = useDispatch();
  const [name, setName] = useState<string>('');

  const handleSearchInput = (e: React.FormEvent<HTMLInputElement>): void => {
    setName(e.currentTarget.value);
  };

  const handleSubmit = async (
    e: React.MouseEvent<HTMLButtonElement>
  ): Promise<void> => {
    e.preventDefault();
    const res: string | undefined = await characterApiName(name);
    if (typeof res === 'string') {
      dispatch(setCurrentPage(1));
    }
  };

  return (
    <form className="d-flex w-100 m-2" role="search">
      <input
        className="form-control me-2 w-100"
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
