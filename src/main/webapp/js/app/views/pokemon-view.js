define(function() {
  var internals = {
    handlers: {},
    elements: {}
  };

  var externals = {};

  internals.renderPokemon = function(pokemon) {
    internals.elements.id = $("#pokeId");
    internals.elements.name = $("#pokeName");
    internals.elements.height = $("#pokeHeight");
    internals.elements.weight = $("#pokeWeight");
    internals.elements.picture = $("#pokePicture");
    internals.elements.type = $("#pokeType");

    internals.elements.id.text(pokemon.id);
    internals.elements.name.text(pokemon.name);
    internals.elements.height.text((Number(pokemon.height) / 10) + " m");
    internals.elements.weight.text((Number(pokemon.weight) / 10) + " kg");
    internals.elements.picture.attr("src", pokemon.picture);
    internals.elements.type.text(pokemon.type.slice(0, -3));

    //window.location.hash = pokemon.id;
  };

  internals.renderButtons = function() {

    // MUSIC BUTTON
    if (internals.elements.bigbluebutton) {
      return;
    }
    internals.elements.bigbluebutton = $("#bigbluebutton");
    internals.elements.bigbluebutton.click(
      internals.handlers["pokemonCry"]
    );

    // D-PAD BUTTONS
    if (internals.elements.midcrossButton) {
      return;
    }
    internals.elements.midcrossButton = $("#midcross");
    internals.elements.midcrossButton.click(
      internals.handlers["randomPokemon"]
    );

    if (internals.elements.rightcrossButton) {
      return;
    }
    internals.elements.rightcrossButton = $("#rightcross");
    internals.elements.rightcrossButton.click(
      internals.handlers["nextPokemon"]
    );

    if (internals.elements.leftcrossButton) {
      return;
    }
    internals.elements.leftcrossButton = $("#leftcross");
    internals.elements.leftcrossButton.click(internals.handlers["prevPokemon"]);

    if (internals.elements.topcrossButton) {
      return;
    }
    internals.elements.topcrossButton = $("#topcross");
    internals.elements.topcrossButton.click(
      internals.handlers["nextTenthPokemon"]
    );

    if (internals.elements.botcrossButton) {
      return;
    }
    internals.elements.botcrossButton = $("#botcross");
    internals.elements.botcrossButton.click(
      internals.handlers["prevTenthPokemon"]
    );

    // YELLOW BUTTONS

    if (internals.elements.yellowBox1) {
      return;
    }
    internals.elements.yellowBox1 = $("#yellowBox1");
    internals.elements.yellowBox1.click(
      internals.handlers["searchPokemonById"]
    );

    if (internals.elements.yellowBox2) {
      return;
   }
    internals.elements.yellowBox2 = $("#yellowBox2");
    internals.elements.yellowBox2.click(
      internals.handlers["clearSearchPokemon"]
    );


    // BLUE NUMERAL BUTTONS

    if (internals.elements.blueButton1) {
      return;
    }
    internals.elements.blueButton1 = $("#blueButton1");
    internals.elements.blueButton1.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton2) {
      return;
    }
    internals.elements.blueButton2 = $("#blueButton2");
    internals.elements.blueButton2.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton3) {
      return;
    }
    internals.elements.blueButton3 = $("#blueButton3");
    internals.elements.blueButton3.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton4) {
      return;
    }
    internals.elements.blueButton4 = $("#blueButton4");
    internals.elements.blueButton4.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton5) {
      return;
    }
    internals.elements.blueButton5 = $("#blueButton5");
    internals.elements.blueButton5.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton6) {
      return;
    }
    internals.elements.blueButton6 = $("#blueButton6");
    internals.elements.blueButton6.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton7) {
      return;
    }
    internals.elements.blueButton7 = $("#blueButton7");
    internals.elements.blueButton7.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton8) {
      return;
    }
    internals.elements.blueButton8 = $("#blueButton8");
    internals.elements.blueButton8.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton9) {
      return;
    }
    internals.elements.blueButton9 = $("#blueButton9");
    internals.elements.blueButton9.click(internals.handlers["searchPokemon"]);

    if (internals.elements.blueButton10) {
      return;
    }
    internals.elements.blueButton10 = $("#blueButton10");
    internals.elements.blueButton10.click(internals.handlers["searchPokemon"]);

    // GREEN AND RED BUTTON BELLOW BLUE BUTTONS
    /*
    if (internals.elements.barbutton4) {
      return;
    }
    internals.elements.barbutton4 = $("#barbutton4");
    internals.elements.barbutton4.click(
      internals.handlers["clearSearchPokemon"]
    );

    if (internals.elements.barbutton3) {
      return;
    }
    internals.elements.barbutton3 = $("#barbutton3");
    internals.elements.barbutton3.click(
      internals.handlers["searchPokemonById"]
    );
    */
  };

  externals.bind = function(event, handler) {
    internals.handlers[event] = handler;
  };

  externals.render = function(pokemon) {
    //internals.elements.app = $("#app");
    internals.renderButtons();

    if (pokemon) {
      internals.renderPokemon(pokemon);
    }
  };

  return externals;
});
