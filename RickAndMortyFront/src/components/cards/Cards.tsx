import type { RootState } from '../../app/store';
import type { Result } from '../../utils/resultsApiInterface';
import type { CardType } from '../../utils/cardType';
import { useSelector } from 'react-redux';
import Card from '../card/Card';
import './Cards.css';

export default function Cards(): JSX.Element {
  const characters = useSelector<RootState, Result[]>(
    (state) => state.characters.characters
  );

  return (
    <div className="card_container">
      {characters?.map((el: CardType) => (
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
