import { useSelector } from 'react-redux';
import Card from '../card/Card';
import './Cards.css';

export default function Cards() {
  const characters = useSelector(
    (state: any) => state.characters.charactersApi
  );
  return (
    <div className="card_container">
      {characters?.map((el: any) => (
        <Card
          key={el.id}
          id={el.id}
          name={el.name}
          status={el.status}
          origin={el.origin.name}
          image={el.image}
        />
      ))}
    </div>
  );
}
