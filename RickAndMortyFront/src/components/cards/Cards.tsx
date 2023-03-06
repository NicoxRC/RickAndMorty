import { useSelector } from 'react-redux';
import Card from '../card/Card';
import './Cards.css';

interface CardInterface {
  id: string | number;
  name: string;
  status: string;
  origin: {
    name: string;
    url: string;
  };
  image: string;
}

export default function Cards() {
  const characters = useSelector(
    (state: any) => state.characters.charactersApi
  );
  return (
    <div className="card_container">
      {characters?.map((el: CardInterface) => (
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
