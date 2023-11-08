import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { setCurrentPage } from '../../slices/paginationSlice';
import type { RootState } from '../../app/store';
import type { CharactersInterface } from '../../interfaces/characters';
import './Pagination.css';
import { setShowCharacters } from '../../slices/characterSlice';

export default function Pagination(): JSX.Element {
  const dispatch = useDispatch();
  const filterCharacters = useSelector<RootState, CharactersInterface[]>(
    (state) => state.characters.filterCharacters
  );
  const currentPage = useSelector<RootState, number>(
    (state) => state.pagination.currentPage
  );
  const pageSize = useSelector<RootState, number>(
    (state) => state.pagination.pageSize
  );

  let index: number[] = [];
  let showPages: number[] = [];
  for (
    let i: number = 1;
    i <= Math.ceil(filterCharacters.length / pageSize);
    i++
  ) {
    index.push(i);
  }

  const handlePageChange = (num: number): void => {
    dispatch(setCurrentPage(num));
  };

  useEffect(() => {
    dispatch(
      setShowCharacters({
        characters: filterCharacters,
        currentPage,
        pageSize,
      })
    );
  }, [filterCharacters, currentPage, pageSize, dispatch]);

  if (index.length <= 1) {
    return <></>;
  } else if (index.length === 2) {
    currentPage === 1
      ? (showPages = [currentPage, currentPage + 1])
      : (showPages = [currentPage - 1, currentPage]);
  } else {
    switch (currentPage) {
      case 1:
        showPages = [currentPage, currentPage + 1, currentPage + 2];
        break;
      case Math.max(...index):
        showPages = [currentPage - 2, currentPage - 1, currentPage];
        break;
      default:
        showPages = [currentPage - 1, currentPage, currentPage + 1];
        break;
    }
  }

  return (
    <nav className="containerPagination">
      <ul className="pagination pagination-lg mt-3">
        {currentPage !== 1 ? (
          <li className="page-item">
            <button
              className="page-link"
              aria-label="Previous"
              onClick={() =>
                handlePageChange(
                  currentPage === 1 ? Math.max(...index) : currentPage - 1
                )
              }
            >
              <span aria-hidden="true">&laquo;</span>
            </button>
          </li>
        ) : null}
        {showPages.map((el) => (
          <li className={el === currentPage ? 'active' : 'item'} key={el}>
            <button className="page-link">{el}</button>
          </li>
        ))}
        {currentPage !== Math.max(...index) ? (
          <li className="page-item">
            <button
              className="page-link"
              aria-label="Next"
              onClick={() =>
                handlePageChange(
                  Math.max(...index) === currentPage ? 1 : currentPage + 1
                )
              }
            >
              <span aria-hidden="true">&raquo;</span>
            </button>
          </li>
        ) : null}
      </ul>
    </nav>
  );
}
