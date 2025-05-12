import PropTypes from "prop-types";

export default function PortfolioItem({ title, description }) {
  return (
    <>
      <div id="portfolio-card">
        <h4>{title}</h4>
        <p>{description}</p>
      </div>
    </>
  );
}

PortfolioItem.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
};
