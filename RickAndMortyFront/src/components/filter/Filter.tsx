import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { filterState } from '../../slices/filterSlice';
import { setCurrentPage, urlFiltered } from '../../slices/paginationSlice';
import { filterProps, filtersEnum } from '../../types/filter';
import type { AppDispatch, RootState } from '../../app/store';

export default function Filter(props: filterProps): JSX.Element {
  const dispatch: AppDispatch = useDispatch();
  const filters = useSelector<RootState>((state) => state.filter.filterType);

  let options: string[] = [];
  switch (props.filterType) {
    case filtersEnum.Gender:
      options = ['Female', 'Male', 'Genderless', 'Unknown'];
      break;
    case filtersEnum.Status:
      options = ['Alive', 'Dead', 'Unknown'];
      break;
    case filtersEnum.Species:
      options = ['Human', 'Alien', 'Humanoid', 'Cronenberg', 'Unknown'];
      break;
    case filtersEnum.Type:
      options = [
        'Parasite',
        'Human with antennae',
        'Fish-Person',
        'Cat-Person',
        'Robot',
      ];
      break;
    default:
      break;
  }

  const handleChange = (e: React.ChangeEvent<HTMLSelectElement>): void => {
    dispatch(
      filterState({
        filter: e.target.value.toLowerCase(),
        type: props.filterType.toLowerCase(),
      })
    );
  };

  useEffect(() => {
    dispatch(urlFiltered({ filters }));
    dispatch(setCurrentPage(1));
  }, [dispatch, filters]);

  return (
    <div className="d-flex m-2">
      <select className="form-select w-100" onChange={handleChange}>
        <option value={props.filterType}>{props.filterType}</option>
        {options.length
          ? options.map((el) => (
              <option value={el} key={el}>
                {el}
              </option>
            ))
          : null}
      </select>
    </div>
  );
}
