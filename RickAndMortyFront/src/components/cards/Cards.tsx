import type { RootState } from '../../app/store';
import type { characterInterface } from '../../utils/characterInterface';
import { useSelector } from 'react-redux';
import { CardInterface } from '../../utils/cardInterface';
import Card from '../card/Card';
import './Cards.css';

export default function Cards(): JSX.Element {
  const characters = useSelector<RootState, characterInterface[]>(
    (state) => state.characters.characters
  );

  return (
    <div className="card_container">
      {characters?.map((el: CardInterface) => (
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
