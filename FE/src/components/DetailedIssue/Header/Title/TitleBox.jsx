import React from "react";

import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";

const TitleBox = ({ id, title, onClickEdit }) => {
  const EDIT_BTN = "edit";

  const classes = useStyles();

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      <Typography variant="h3" component="h2">
        <span>{title}</span>
        {id && <span className={classes.issueNum}>#{id}</span>}
      </Typography>
      <Button variant="contained" onClick={onClickEdit}>
        {EDIT_BTN}
      </Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  issueNum: {
    color: theme.palette.text.secondary,
    marginLeft: theme.spacing(2),
  },
}));

// TitleBox.defaultProps = {
//   text: "",
//   title: "",
//   clickHandler: null,
//   options: {
//     name: "",
//     label: null,
//     avatar: null,
//   },
// };

export default TitleBox;
