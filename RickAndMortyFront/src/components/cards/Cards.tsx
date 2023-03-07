import { useSelector } from 'react-redux';
import { CardInterface } from '../../utils/cardInterface';
import Card from '../card/Card';
import './Cards.css';
export default function Cards() {
  const characters = useSelector((state: any) => state.characters.characters);

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
