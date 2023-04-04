import { useState } from 'react';
import { filters } from '../../utils/filterType';
import { useDispatch } from 'react-redux';
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

export default function Filter(filterType: filters): JSX.Element {
  const dispatch = useDispatch();
  const [options, setOptions] = useState<string[]>([]);

  switch (filterType) {
    case filters.Gender:
      setOptions(['Female', 'Male', 'Genderless', 'Unknown']);
      break;
    case filters.Status:
      setOptions(['Alive', 'Dead', 'Unknown']);
      break;
    case filters.Species:
      setOptions(['Human', 'Alien', 'Humanoid', 'Unknown']);
      break;
    case filters.Type:
      setOptions([
        'Parasite',
        'Human with antennae',
        'Fish-Person',
        'Cat-Person',
      ]);
      break;
    default:
      break;
  }

  const handleClick = () => {
    //code
  };

  return (
    <div>
      <DropdownButton id="dropdown-basic-button" title="Dropdown button">
        {options.length
          ? options.map((el) => (
              <Dropdown.Item onClick={handleClick}>
                <button className="btn btn-success">{el}</button>
              </Dropdown.Item>
            ))
          : null}
      </DropdownButton>
    </div>
  );
}
