import { CardInterface } from '../../utils/cardInterface';

export default function Card(props: CardInterface) {
  const { name, status, origin, image } = props;

  return (
    <div className="card text-bg-dark" style={{ width: '25rem' }}>
      <img src={image} className="card-img-top" alt="character" />
      <div className="card-body">
        <h2 className="card-title">{name}</h2>
        <p className="card-text">
          <b>Status:</b> {status}
        </p>
        <p className="card-text">
          <b>Origin:</b> {origin.name}
        </p>
        <button className="btn btn-success">Go somewhere</button>
      </div>
    </div>
  );
}
