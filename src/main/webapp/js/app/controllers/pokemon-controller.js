define(["views/pokemon-view", "services/pokemon-service"], function(
  pokemonView,
  pokemonService
) {
  var externals = {};
  var internals = {};

  externals.start = function() {
    internals.bindEventHandlers();
    pokemonView.render();
  };

  internals.bindEventHandlers = function() {
    pokemonView.bind("randomPokemon", internals.randomPokemonHandler);
    pokemonView.bind("nextPokemon", internals.nextPokemonHandler);
    pokemonView.bind("prevPokemon", internals.prevPokemonHandler);
    pokemonView.bind("nextTenthPokemon", internals.nextTenthPokemonHandler);
    pokemonView.bind("prevTenthPokemon", internals.prevTenthPokemonHandler);

    //pokemonView.bind("rotatePokemon", internals.rotatePokemonHandler);

    pokemonView.bind("searchPokemon", internals.searchPokemonHandler);
    pokemonView.bind("clearSearchPokemon", internals.clearSearchPokemon);
    pokemonView.bind("searchPokemonById", internals.searchPokemonById);
    pokemonView.bind("pokemonCry", internals.pokemonCry);
  }

  internals.pokemonCry = function() {
    var audio = new Audio("https://pokemoncries.com/cries-old/" + $("#pokeId").text() + ".mp3");
    audio.play();
  }

  internals.searchPokemonById = function() {
    pokemonService.getPokemon($("#pokeId").text()).then(pokemonView.render)
  };

  internals.clearSearchPokemon = function() {
    $("#pokeId").text("");
  };

  internals.searchPokemonHandler = function(number) {
    var pokemonId = $("#pokeId").text();

    $("#pokeId").text(pokemonId + number.target.textContent);
  };

  internals.randomPokemonHandler = function() {
    var pokemonId = Math.floor(Math.random() * 150) || 1;
    pokemonService.getPokemon(pokemonId).then(pokemonView.render);
  };

  internals.nextPokemonHandler = function() {
    var pokemonId = Number($("#pokeId").text()) || 0;
    if (pokemonId <= 801) {
      pokemonId = pokemonId + 1;
    }
    pokemonService.getPokemon(pokemonId).then(pokemonView.render);
  };

  internals.prevPokemonHandler = function() {
    var pokemonId = Number($("#pokeId").text()) || 1;
    if (pokemonId > 1) {
      pokemonId = pokemonId - 1;
    }
    pokemonService.getPokemon(pokemonId).then(pokemonView.render);
  };

  internals.nextTenthPokemonHandler = function() {
    var pokemonId = Number($("#pokeId").text()) || -9;
    if (pokemonId <= 792) {
      pokemonId = pokemonId + 10;
    }
    pokemonService.getPokemon(pokemonId).then(pokemonView.render);
  };

  internals.prevTenthPokemonHandler = function() {
    var pokemonId = Number($("#pokeId").text()) || 11;
    if (pokemonId > 10) {
      pokemonId = pokemonId - 10;
    }
    pokemonService.getPokemon(pokemonId).then(pokemonView.render);
  };

  return externals;
});
