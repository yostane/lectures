export default function PortfolioItem({ title, description }) {
  return (
    <>
      <div class="portfolio-item">
        <h4>{title}</h4>
        <p>{description}</p>
      </div>
    </>
  );
}
