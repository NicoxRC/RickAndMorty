import { RootState } from '../../app/store';
import { filterState } from '../../slices/filterSlice';
import { filterProps, filtersEnum } from '../../utils/filterType';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { urlFiltered } from '../../slices/paginationSlice';

export default function Filter(props: filterProps): JSX.Element {
  const dispatch = useDispatch();
  const filters = useSelector<RootState>((state) => state.filter.filtersType);

  let options: string[] = [];
  switch (props.filterType) {
    case filtersEnum.Gender:
      options = ['Female', 'Male', 'Genderless', 'Unknown'];
      break;
    case filtersEnum.Status:
      options = ['Alive', 'Dead', 'Unknown'];
      break;
    case filtersEnum.Species:
      options = ['Human', 'Alien', 'Humanoid', 'Unknown'];
      break;
    case filtersEnum.Type:
      options = [
        'Parasite',
        'Human with antennae',
        'Fish-Person',
        'Cat-Person',
      ];
      break;
    default:
      break;
  }

  const handleChange = (e: React.ChangeEvent<HTMLSelectElement>): void => {
    dispatch(
      filterState({
        filter: e.target.value,
        type: props.filterType.toLowerCase(),
      })
    );
  };

  useEffect(() => {
    dispatch(urlFiltered({ filters }));
  }, [dispatch, filters]);

  return (
    <div className="d-flex m-2">
      <select className="form-select w-100" onChange={handleChange}>
        <option hidden>{props.filterType}</option>
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
