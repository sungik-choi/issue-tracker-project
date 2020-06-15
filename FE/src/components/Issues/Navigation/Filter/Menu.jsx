import React from "react";

import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

const Menu = () => {
  return (
    <>
      <PopoverPopupState />
    </>
  );
};

function PopoverPopupState() {
  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <div>
          <Button variant="contained" color="default" {...bindTrigger(popupState)}>
            <span style={{ fontSize: "13px", fontWeight: "bold" }}>
              Filters
              <ArrowDropDownIcon style={{ verticalAlign: "middle" }} />
            </span>
          </Button>
          <Popover
            {...bindPopover(popupState)}
            anchorOrigin={{
              vertical: "bottom",
              horizontal: "center",
            }}
            transformOrigin={{
              vertical: "top",
              horizontal: "center",
            }}
          >
            <Box p={2}>
              <Typography>The content of the Popover.</Typography>
            </Box>
          </Popover>
        </div>
      )}
    </PopupState>
  );
}

export default Menu;
