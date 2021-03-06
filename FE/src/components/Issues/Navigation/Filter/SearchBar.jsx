import React from "react";

import { makeStyles } from "@material-ui/core/styles";

import Box from "@material-ui/core/Box";
import InputBase from "@material-ui/core/InputBase";
import SearchIcon from "@material-ui/icons/Search";

const SearchBar = () => {
  const SEARCH_PLACEHOLDER = "Search all issues";
  const classes = useStyles();

  return (
    <Box
      component="form"
      aria-label="Issues"
      display="flex"
      alignItems="center"
      className={classes.search}
    >
      <div className={classes.searchIcon}>
        <SearchIcon />
      </div>
      <InputBase
        placeholder={SEARCH_PLACEHOLDER}
        classes={{
          root: classes.inputRoot,
          input: classes.inputInput,
        }}
        inputProps={{ "aria-label": "Search all issues" }}
      />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  search: {
    borderRadius: "0 4px 4px 0",
    border: `1px solid ${theme.palette.divider}`,
    borderLeft: "none",
  },
  searchIcon: {
    padding: theme.spacing(0, 1),
    color: theme.palette.grey[400],
    pointerEvents: "none",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  inputRoot: {
    color: "inherit",
  },
  inputInput: {
    transition: theme.transitions.create("width"),
    [theme.breakpoints.up("md")]: {
      width: "550px",
    },
  },
}));

export default SearchBar;
