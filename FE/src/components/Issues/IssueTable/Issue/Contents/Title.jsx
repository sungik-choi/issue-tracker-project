import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Link from "@material-ui/core/Link";
import Typography from "@material-ui/core/Typography";

// ! 해당 이슈로 가는 링크 지정 필요

const Title = ({ title }) => {
  return (
    <Box marginRight={1}>
      <Typography variant="h6">
        <Link href="#" color="inherit">
          {title}
        </Link>
      </Typography>
    </Box>
  );
};

Title.propTypes = {
  title: PropTypes.string.isRequired,
};

export default Title;
