define(function() {
  var internals = {}; // internal state
  var externals = {}; // external api

  var api = "https://pokeapi.co/api/v2/pokemon/";

  internals.fetch = function(url) {
    return new Promise(function(resolve, reject) {
      $.ajax({
        url: url
      })
        .done(resolve)
        .fail(reject);
    });
  };

  function getPokemonStats(pokemon) {
    return {
      id: pokemon.id,
      name: pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1),
      height: pokemon.height,
      weight: pokemon.weight,
      picture: pokemon.sprites.front_default, 
      //back_picture: pokemon.sprites.back_default
      type: pokemon.types.reduce(function(str, each) {
        return str + each.type.name.charAt(0).toUpperCase() + each.type.name.slice(1) + " & ";
      },"")
    };
  }

  function showMissigno() {
    return {
      id: "",
      name: "MissingNo.",
      height: "10",
      weight: "100",
      picture: "https://cdn.bulbagarden.net/upload/9/98/Missingno_RB.png", 
      //back_picture: pokemon.sprites.back_default
      type: "Bird & Normal & "
    };
  }

  externals.getPokemon = function(pokemonId) {
    return internals.fetch(api + pokemonId).then(getPokemonStats).catch(showMissigno);
  };

  return externals;
});
