import Card from '../card/Card';
import { useSelector } from 'react-redux';
import type { RootState } from '../../app/store';
import type { CardPropsType } from '../../types/card';
import type { CharactersInterface } from '../../interfaces/characters';
import './Cards.css';

export default function Cards(): JSX.Element {
  const characters = useSelector<RootState, CharactersInterface[]>(
    (state) => state.characters.characters
  );

  return (
    <div className="card_container">
      {characters?.map((el: CardPropsType) => (
        <Card
          key={el.id}
          id={el.id}
          name={el.name}
          status={el.status}
          origin={el.origin}
          image={el.image}
        />
      ))}
    </div>
  );
}
