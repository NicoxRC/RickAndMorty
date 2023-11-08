import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { filterState } from '../../slices/filterSlice';
import { setCurrentPage } from '../../slices/paginationSlice';
import { CharactersFilter } from '../../slices/characterSlice';
import { FilterPropsType, FilterType, FiltersEnum } from '../../types/filter';
import type { AppDispatch, RootState } from '../../app/store';

export default function Filter(props: FilterPropsType) {
  const { filterType } = props;
  const dispatch: AppDispatch = useDispatch();
  const filters = useSelector<RootState, FilterType>(
    (state) => state.filter.filterType
  );

  let options: string[] = [];
  switch (filterType) {
    case FiltersEnum.Gender:
      options = ['Female', 'Male', 'Genderless', 'Unknown'];
      break;
    case FiltersEnum.Status:
      options = ['Alive', 'Dead', 'Unknown'];
      break;
    case FiltersEnum.Species:
      options = ['Human', 'Alien', 'Humanoid', 'Cronenberg', 'Unknown'];
      break;
    case FiltersEnum.Type:
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
        type: filterType.toLowerCase(),
        filter: e.target.value,
      })
    );
  };

  useEffect(() => {
    dispatch(CharactersFilter(filters));
    dispatch(setCurrentPage(1));
  }, [dispatch, filters]);

  return (
    <div className="d-flex m-2">
      <select className="form-select w-100" onChange={handleChange}>
        <option value={filterType}>{filterType}</option>
        {options.length
          ? options.map((el: string) => (
              <option value={el} key={el}>
                {el}
              </option>
            ))
          : null}
      </select>
    </div>
  );
}
