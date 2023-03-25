import type { RootState } from '../../app/store';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { charactersApi } from '../../services/charactersApi';
import { showCharacters } from '../../slices/characterSlice';
import { characterInterface } from '../../utils/characterInterface';
import { url } from '../../slices/paginationSlice';
import { setCurrentPage } from '../../slices/paginationSlice';
import './Pagination.css';

export default function Pagination(): JSX.Element {
  const dispatch = useDispatch();
  const currentUrl = useSelector<RootState, string>(
    (state) => state.pagination.currentPageUrl
  );
  const currentPage = useSelector<RootState, number>(
    (state) => state.pagination.currentPage
  );
  const [characters, setCharacters] = useState<characterInterface[]>([]);
  const [nextPageUrl, setNextPageUrl] = useState<string>();
  const [prevPageUrl, setPrevPageUrl] = useState<string>();
  const [pages, setPages] = useState<number>(0);

  let index: number[] = [];
  let showPages: number[] = [];

  useEffect(() => {
    (async () => {
      const res = await charactersApi(currentUrl);
      setCharacters(res.results);
      setNextPageUrl(res.info.next);
      setPrevPageUrl(res.info.prev);
      setPages(res.info.pages);
    })();
  }, [currentUrl]);

  useEffect(() => {
    dispatch(showCharacters(characters));
  }, [characters, dispatch]);

  for (let i: number = 1; i <= pages; i++) {
    index.push(i);
  }

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

  const handleNextPage = (num: number): void => {
    if (nextPageUrl) {
      dispatch(url(nextPageUrl));
    }
    dispatch(setCurrentPage(num));
  };

  const handlePrevPage = (num: number): void => {
    if (prevPageUrl) {
      dispatch(url(prevPageUrl));
    }
    dispatch(setCurrentPage(num));
  };

  return (
    <nav className="containerPagination">
      <ul className="pagination pagination-lg mt-3">
        {prevPageUrl ? (
          <li className="page-item">
            <button
              className="page-link"
              aria-label="Previous"
              onClick={() =>
                handlePrevPage(
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
        {nextPageUrl ? (
          <li className="page-item">
            <button
              className="page-link"
              aria-label="Next"
              onClick={() =>
                handleNextPage(
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
