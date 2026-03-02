/*!
 * Simple Validate
 * Version: 1.0
 * Author: Jose Ramos - LIQUID
 * Website: http://meetliquid.com/
 */
(function ($) {
  'use strict';
  $.fn.formValidate = function (options) {
    var defaults = {
      'errorclass': 'is-error',
      'disallow': ''
    },
    opts = $.extend(defaults, options),
    bool = true,
    finish = true,
    inputs = this.find('*[data-valid]');

    inputs.each(function () {
      var myelem = $(this),
        parent = myelem.parent().parent();

      switch (myelem.attr('data-valid')) {
        case 'email':       bool = validEmail(myelem.val()); break;
        case 'required':    bool = validRequired(myelem); break;
        case 'integer':     bool = validInt(myelem.val()); break;
        case 'dni':         bool = validDni(myelem.val()); break;
        case 'ruc':         bool = validRuc(myelem.val()); break;
        case 'amount':      bool = validAmount(myelem); break;
        case 'check-group': bool = validCheckboxGroup(myelem); parent = myelem; myelem.val('1'); break;
        case 'radio-group': bool = validRadioGroup(myelem); parent = myelem; myelem.val('1'); break;
        case 'account': bool = validAccount(myelem); break;
      }

      if (!bool || myelem.val() === myelem.attr('data-holder') || myelem.val() == opts.disallow) {
        parent.addClass(opts.errorclass);
        finish = false;
        bool = true;
      } else {
        parent.removeClass(opts.errorclass);
      }
    });

    function validEmail(valor) { return (/^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(valor)) ? true : false; }
    function validInt(valor) { return (/^\d+$/.test(valor)) ? true : false; }
    function validDni(valor) { return (/^\d+$/.test(valor) && valor.length === 8) ? true : false; }
    function validRuc(valor) { return (/^\d+$/.test(valor) && valor.length === 11) ? true : false; }
    function validRequired(elem) {
      if (elem.is('select')) {
        return ($.trim(elem.val()) !== '') ? true : false;
      } else if (elem.is('input[type="checkbox"]')) {
        return (elem.prop('checked')) ? true : false;
      } else {
        return (/[^.*\s]/.test(elem.val())) ? true : false;
      }
    }

    function validCheckboxGroup(elem) {
      return (elem.find('input[type="checkbox"]:checked').length > 0) ? true : false;
    }

    function validRadioGroup(elem) {
      return (elem.find('input[type="radio"]:checked').length > 0) ? true : false;
    }

    function validAmount(elem) {
      return (/[^.*\s]/.test(elem.val())
        && parseFloat(elem.val()) >= parseFloat(elem.attr('data-min'))
        && parseFloat(elem.val()) <= parseFloat(elem.attr('data-max')) ) ? true : false;
    }
    
    function validAccount(elem){
   	 return (/[^.*\s]/.test(elem.val())
   		        && elem.val().length >= parseFloat(elem.attr('data-min'))
   		        && elem.val().length <= parseFloat(elem.attr('data-max')) ) ? true : false;
   }

    return finish;
  };

  $.fn.blurValidate = function (options) {
    var defaults = { 'errorclass': 'error' },
      opts = $.extend(defaults, options),
      inputs = this.find('*[data-valid]');

    inputs.each(function () {
      var elem   = $(this),
        parent = elem.parent();

      if (elem.is('input') || elem.is('textarea')) {
        elem.blur(function () {
          parent.formValidate();
        });
      }

      if (elem.is('select')) {
        elem.on("change blur", function () {
          parent.formValidate();
        });
      }

      if (elem.attr('data-valid') === 'check-group') {
        elem.find('.checkbox label').on("click", function () {
          parent.formValidate();
        });
      }
    });
  };
}(jQuery));

/********************************************************************
* Limit the characters that may be entered in a text field
* Common options: alphanumeric, alphabetic or numeric
* Kevin Sheedy, 2012
* http://github.com/KevinSheedy/jquery.alphanum
*********************************************************************/
(function( $ ){

  // API ///////////////////////////////////////////////////////////////////
  $.fn.alphanum = function(settings) {

    var combinedSettings = getCombinedSettingsAlphaNum(settings);

    var $collection = this;

    setupEventHandlers($collection, trimAlphaNum, combinedSettings);

    return this;
  };

  $.fn.alpha = function(settings) {

    var defaultAlphaSettings = getCombinedSettingsAlphaNum('alpha');
    var combinedSettings = getCombinedSettingsAlphaNum(settings, defaultAlphaSettings);

    var $collection = this;

    setupEventHandlers($collection, trimAlphaNum, combinedSettings);

    return this;
  };

  $.fn.numeric = function(settings) {

    var combinedSettings = getCombinedSettingsNum(settings);
    var $collection = this;

    setupEventHandlers($collection, trimNum, combinedSettings);

    $collection.blur(function(){
      numericField_Blur(this, combinedSettings);
    });

    return this;
  };

  // End of API /////////////////////////////////////////////////////////////


  // Start Settings ////////////////////////////////////////////////////////

  var DEFAULT_SETTINGS_ALPHANUM = {
    allow              : '',    // Allow extra characters
    disallow           : '',    // Disallow extra characters
    allowSpace         : true,  // Allow the space character
    allowNewline       : true,  // Allow the newline character \n ascii 10
    allowNumeric       : true,  // Allow digits 0-9
    allowUpper         : true,  // Allow upper case characters
    allowLower         : true,  // Allow lower case characters
    allowCaseless      : true,  // Allow characters that don't have both upper & lower variants - eg Arabic or Chinese
    allowLatin         : true,  // a-z A-Z
    allowOtherCharSets : true,  // eg é, Á, Arabic, Chinese etc
    forceUpper         : false, // Convert lower case characters to upper case
    forceLower         : false, // Convert upper case characters to lower case
    maxLength          : NaN    // eg Max Length
  };

  var DEFAULT_SETTINGS_NUM = {
    allowPlus           : false, // Allow the + sign
    allowMinus          : true,  // Allow the - sign
    allowThouSep        : true,  // Allow the thousands separator, default is the comma eg 12,000
    allowDecSep         : true,  // Allow the decimal separator, default is the fullstop eg 3.141
    allowLeadingSpaces  : false,
    maxDigits           : NaN,   // The max number of digits
    maxDecimalPlaces    : NaN,   // The max number of decimal places
    maxPreDecimalPlaces : NaN,   // The max number digits before the decimal point
    max                 : NaN,   // The max numeric value allowed
    min                 : NaN    // The min numeric value allowed
  };

  // Some pre-defined groups of settings for convenience
  var CONVENIENCE_SETTINGS_ALPHANUM = {
    'alpha' : {
      allowNumeric  : false
    },
    'upper' : {
      allowNumeric  : false,
      allowUpper    : true,
      allowLower    : false,
      allowCaseless : true
    },
    'lower' : {
      allowNumeric  : false,
      allowUpper    : false,
      allowLower    : true,
      allowCaseless : true
    }
  };

  // Some pre-defined groups of settings for convenience
  var CONVENIENCE_SETTINGS_NUMERIC = {
    'integer' : {
      allowPlus    : false,
      allowMinus   : true,
      allowThouSep : false,
      allowDecSep  : false
    },
    'positiveInteger' : {
      allowPlus    : false,
      allowMinus   : false,
      allowThouSep : false,
      allowDecSep  : false
    }
  };


  var BLACKLIST   = getBlacklistAscii() + getBlacklistNonAscii();
  var THOU_SEP    = ',';
  var DEC_SEP     = '.';
  var DIGITS      = getDigitsMap();
  var LATIN_CHARS = getLatinCharsSet();

  // Return the blacklisted special chars that are encodable using 7-bit ascii
  function getBlacklistAscii(){
    var blacklist = '!@#$%^&*()+=[]\\\';,/{}|":<>?~`.-_';
    blacklist += ' '; // 'Space' is on the blacklist but can be enabled using the 'allowSpace' config entry
    return blacklist;
  }

  // Return the blacklisted special chars that are NOT encodable using 7-bit ascii
  // We want this .js file to be encoded using 7-bit ascii so it can reach the widest possible audience
  // Higher order chars must be escaped eg "\xAC"
  // Not too worried about comments containing higher order characters for now (let's wait and see if it becomes a problem)
  function getBlacklistNonAscii(){
    var blacklist =
        '\xAC'     // ¬
      + '\u20AC'   // €
      + '\xA3'     // £
      + '\xA6'     // ¦
      ;
    return blacklist;
  }

  // End Settings ////////////////////////////////////////////////////////


  // Implementation details go here ////////////////////////////////////////////////////////

  function setupEventHandlers($textboxes, trimFunction, settings) {

    $textboxes.each(function(){

      var $textbox = $(this);

      $textbox
        // Unbind existing alphanum event handlers
        .off('.alphanum')

        .on('keyup.alphanum change.alphanum paste.alphanum', function(e){

          var pastedText = '';

          if(e.originalEvent && e.originalEvent.clipboardData && e.originalEvent.clipboardData.getData)
            pastedText = e.originalEvent.clipboardData.getData('text/plain');

          // setTimeout is necessary for handling the 'paste' event
          setTimeout(function(){
            trimTextbox($textbox, trimFunction, settings, pastedText);
          }, 0);
        })

        .on('keypress.alphanum', function(e){

        // Determine which key is pressed.
        // If it's a control key, then allow the event's default action to occur eg backspace, tab
          var charCode = !e.charCode ? e.which : e.charCode;
          if(isControlKey(charCode)
          || e.ctrlKey
          || e.metaKey ) // cmd on MacOS
            return;

          var newChar         = String.fromCharCode(charCode);

          // Determine if some text was selected / highlighted when the key was pressed
          var selectionObject = $textbox.selection();
          var start = selectionObject.start;
          var end   = selectionObject.end;

          var textBeforeKeypress  = $textbox.val();

          // The new char may be inserted:
          //  1) At the start
          //  2) In the middle
          //  3) At the end
          //  4) User highlights some text and then presses a key which would replace the highlighted text
          //
          // Here we build the string that would result after the keypress.
          // If the resulting string is invalid, we cancel the event.
          // Unfortunately, it isn't enough to just check if the new char is valid because some chars
          // are position sensitive eg the decimal point '.'' or the minus sign '-'' are only valid in certain positions.
          var potentialTextAfterKeypress = textBeforeKeypress.substring(0, start) + newChar + textBeforeKeypress.substring(end);
          var validatedText              = trimFunction(potentialTextAfterKeypress, settings);

          // If the keypress would cause the textbox to contain invalid characters, then cancel the keypress event
          if(validatedText != potentialTextAfterKeypress)
            e.preventDefault();
        });
    });

  }

  // Ensure the text is a valid number when focus leaves the textbox
  // This catches the case where a user enters '-' or '.' without entering any digits
  function numericField_Blur(inputBox, settings) {
    var fieldValueNumeric = parseFloat($(inputBox).val());
    var $inputBox = $(inputBox);

    if(isNaN(fieldValueNumeric)) {
      $inputBox.val('');
      return;
    }

    if(isNumeric(settings.min) && fieldValueNumeric < settings.min)
      $inputBox.val('');

    if(isNumeric(settings.max) && fieldValueNumeric > settings.max)
      $inputBox.val('');
  }

  function isNumeric(value) {
    return !isNaN(value);
  }

  function isControlKey(charCode) {

    if(charCode >= 32)
      return false;
    if(charCode == 10)
      return false;
    if(charCode == 13)
      return false;

    return true;
  }

  // One way to prevent a character being entered is to cancel the keypress event.
  // However, this gets messy when you have to deal with things like copy paste which isn't a keypress.
  // Which event gets fired first, keypress or keyup? What about IE6 etc etc?
  // Instead, it's easier to allow the 'bad' character to be entered and then to delete it immediately after.

  function trimTextbox($textBox, trimFunction, settings, pastedText){

    var inputString = $textBox.val();

    if(inputString == '' && pastedText.length > 0)
      inputString = pastedText;

    var outputString = trimFunction(inputString, settings);

    if(inputString == outputString)
      return;

    var caretPos = $textBox.alphanum_caret();

    $textBox.val(outputString);

    //Reset the caret position
    if(inputString.length ==(outputString.length + 1))
      $textBox.alphanum_caret(caretPos - 1);
    else
      $textBox.alphanum_caret(caretPos);
  }

  function getCombinedSettingsAlphaNum(settings, defaultSettings){
    if(typeof defaultSettings == 'undefined')
      defaultSettings = DEFAULT_SETTINGS_ALPHANUM;
    var userSettings, combinedSettings = {};
    if(typeof settings === 'string')
      userSettings = CONVENIENCE_SETTINGS_ALPHANUM[settings];
    else if(typeof settings == 'undefined')
      userSettings = {};
    else
      userSettings = settings;

    $.extend(combinedSettings, defaultSettings, userSettings);

    if(typeof combinedSettings.blacklist == 'undefined')
      combinedSettings.blacklistSet = getBlacklistSet(combinedSettings.allow, combinedSettings.disallow);

    return combinedSettings;
  }

  function getCombinedSettingsNum(settings){
    var userSettings, combinedSettings = {};
    if(typeof settings === 'string')
      userSettings = CONVENIENCE_SETTINGS_NUMERIC[settings];
    else if(typeof settings == 'undefined')
      userSettings = {};
    else
      userSettings = settings;

    $.extend(combinedSettings, DEFAULT_SETTINGS_NUM, userSettings);

    return combinedSettings;
  }


  // This is the heart of the algorithm
  function alphanum_allowChar(validatedStringFragment, Char, settings){

    if(settings.maxLength && validatedStringFragment.length >= settings.maxLength)
      return false;

    if(settings.allow.indexOf(Char) >=0 )
      return true;

    if(settings.allowSpace && (Char == ' '))
      return true;

    if(!settings.allowNewline && (Char == '\n' || Char == '\r'))
      return false;

    if(settings.blacklistSet.contains(Char))
      return false;

    if(!settings.allowNumeric && DIGITS[Char])
      return false;

    if(!settings.allowUpper && isUpper(Char))
      return false;

    if(!settings.allowLower && isLower(Char))
      return false;

    if(!settings.allowCaseless && isCaseless(Char))
      return false;

    if(!settings.allowLatin && LATIN_CHARS.contains(Char))
      return false;

    if(!settings.allowOtherCharSets){
      if(DIGITS[Char] || LATIN_CHARS.contains(Char))
        return true;
      else
        return false;
    }

    return true;
  }

  function numeric_allowChar(validatedStringFragment, Char, settings){

    if(DIGITS[Char]) {

      if(isMaxDigitsReached(validatedStringFragment, settings))
        return false;

      if(isMaxPreDecimalsReached(validatedStringFragment, settings))
        return false;

      if(isMaxDecimalsReached(validatedStringFragment, settings))
        return false;

      if(isGreaterThanMax(validatedStringFragment + Char, settings))
        return false;

      if(isLessThanMin(validatedStringFragment + Char, settings))
        return false;

      return true;
    }

    if(settings.allowPlus && Char == '+' && validatedStringFragment == '')
      return true;

    if(settings.allowMinus && Char == '-' && validatedStringFragment == '')
      return true;

    if(Char == THOU_SEP && settings.allowThouSep && allowThouSep(validatedStringFragment))
      return true;

    if(Char == DEC_SEP) {
      // Only one decimal separator allowed
      if(validatedStringFragment.indexOf(DEC_SEP) >= 0)
        return false;
      // Don't allow decimal separator when maxDecimalPlaces is set to 0
      if(settings.allowDecSep && settings.maxDecimalPlaces === 0)
        return false;
      if(settings.allowDecSep)
        return true;
    }

    return false;
  }

  function countDigits(string) {

    // Error handling, nulls etc
    string = string + '';

    // Count the digits
    return string.replace(/[^0-9]/g,'').length;
  }

  function isMaxDigitsReached(string, settings) {

    var maxDigits = settings.maxDigits;

    if(maxDigits === '' || isNaN(maxDigits))
      return false; // In this case, there is no maximum

    var numDigits = countDigits(string);

    if(numDigits >= maxDigits)
      return true;

    return false;
  }

  function isMaxDecimalsReached(string, settings) {

    var maxDecimalPlaces = settings.maxDecimalPlaces;

    if(maxDecimalPlaces === '' || isNaN(maxDecimalPlaces))
      return false; // In this case, there is no maximum

    var indexOfDecimalPoint = string.indexOf(DEC_SEP);

    if(indexOfDecimalPoint == -1)
      return false;

    var decimalSubstring = string.substring(indexOfDecimalPoint);
    var numDecimals = countDigits(decimalSubstring);

    if(numDecimals >= maxDecimalPlaces)
      return true;

    return false;
  }

  function isMaxPreDecimalsReached(string, settings) {

    var maxPreDecimalPlaces = settings.maxPreDecimalPlaces;

    if(maxPreDecimalPlaces === '' || isNaN(maxPreDecimalPlaces))
      return false; // In this case, there is no maximum

    var indexOfDecimalPoint = string.indexOf(DEC_SEP);

    if(indexOfDecimalPoint >= 0)
      return false;

    var numPreDecimalDigits = countDigits(string);

    if(numPreDecimalDigits >= maxPreDecimalPlaces)
      return true;

    return false;
  }

  function isGreaterThanMax(numericString, settings) {

    if(!settings.max || settings.max < 0)
      return false;

    var outputNumber = parseFloat(numericString);
    if(outputNumber > settings.max)
      return true;

    return false;
  }

  function isLessThanMin(numericString, settings) {

    if(!settings.min || settings.min > 0)
      return false;

    var outputNumber = parseFloat(numericString);
    if(outputNumber < settings.min)
      return true;

    return false;
  }

  /********************************
   * Trims a string according to the settings provided
   ********************************/
  function trimAlphaNum(inputString, settings){

    if(typeof inputString != 'string')
      return inputString;

    var inChars = inputString.split('');
    var outChars = [];
    var i = 0;
    var Char;

    for(i=0; i<inChars.length; i++){
      Char = inChars[i];
      var validatedStringFragment = outChars.join('');
      if(alphanum_allowChar(validatedStringFragment, Char, settings))
        outChars.push(Char);
    }

    var outputString = outChars.join('');

    if(settings.forceLower)
      outputString = outputString.toLowerCase();
    else if(settings.forceUpper)
      outputString = outputString.toUpperCase();

    return outputString;
  }

  function trimNum(inputString, settings){
    if(typeof inputString != 'string')
      return inputString;

    var inChars = inputString.split('');
    var outChars = [];
    var i = 0;
    var Char;

    for(i=0; i<inChars.length; i++){
      Char = inChars[i];
      var validatedStringFragment = outChars.join('');
      if(numeric_allowChar(validatedStringFragment, Char, settings))
        outChars.push(Char);
    }

    return outChars.join('');
  }

  function isUpper(Char){
    var upper = Char.toUpperCase();
    var lower = Char.toLowerCase();

    if( (Char == upper) && (upper != lower))
      return true;
    else
      return false;
  }

  function isLower(Char){
    var upper = Char.toUpperCase();
    var lower = Char.toLowerCase();

    if( (Char == lower) && (upper != lower))
      return true;
    else
      return false;
  }

  function isCaseless(Char){
    if(Char.toUpperCase() == Char.toLowerCase())
      return true;
    else
      return false;
  }

  function getBlacklistSet(allow, disallow){

    var setOfBadChars  = new Set(BLACKLIST + disallow);
    var setOfGoodChars = new Set(allow);

    var blacklistSet   = setOfBadChars.subtract(setOfGoodChars);

    return blacklistSet;
  }

  function getDigitsMap(){
    var array = '0123456789'.split('');
    var map = {};
    var i = 0;
    var digit;

    for(i=0; i<array.length; i++){
      digit = array[i];
      map[digit] = true;
    }

    return map;
  }

  function getLatinCharsSet(){
    var lower = 'abcdefghijklmnopqrstuvwxyz';
    var upper = lower.toUpperCase();
    var azAZ = new Set(lower + upper);

    return azAZ;
  }

  function allowThouSep(currentString) {

    // Can't start with a THOU_SEP
    if(currentString.length == 0)
      return false;

    // Can't have a THOU_SEP anywhere after a DEC_SEP
    var posOfDecSep = currentString.indexOf(DEC_SEP);
    if(posOfDecSep >= 0)
      return false;

    var posOfFirstThouSep       = currentString.indexOf(THOU_SEP);

    // Check if this is the first occurrence of a THOU_SEP
    if(posOfFirstThouSep < 0)
      return true;

    var posOfLastThouSep        = currentString.lastIndexOf(THOU_SEP);
    var charsSinceLastThouSep   = currentString.length - posOfLastThouSep - 1;

    // Check if there has been 3 digits since the last THOU_SEP
    if(charsSinceLastThouSep < 3)
      return false;

    var digitsSinceFirstThouSep = countDigits(currentString.substring(posOfFirstThouSep));

    // Check if there has been a multiple of 3 digits since the first THOU_SEP
    if((digitsSinceFirstThouSep % 3) > 0)
      return false;

    return true;
  }

  ////////////////////////////////////////////////////////////////////////////////////
  // Implementation of a Set
  ////////////////////////////////////////////////////////////////////////////////////
  function Set(elems){
    if(typeof elems == 'string')
      this.map = stringToMap(elems);
    else
      this.map = {};
  }

  Set.prototype.add = function(set){

    var newSet = this.clone();

    for(var key in set.map)
      newSet.map[key] = true;

    return newSet;
  };

  Set.prototype.subtract = function(set){

    var newSet = this.clone();

    for(var key in set.map)
      delete newSet.map[key];

    return newSet;
  };

  Set.prototype.contains = function(key){
    if(this.map[key])
      return true;
    else
      return false;
  };

  Set.prototype.clone = function(){
    var newSet = new Set();

    for(var key in this.map)
      newSet.map[key] = true;

    return newSet;
  };
  ////////////////////////////////////////////////////////////////////////////////////

  function stringToMap(string){
    var map = {};
    var array = string.split('');
    var i=0;
    var Char;

    for(i=0; i<array.length; i++){
      Char = array[i];
      map[Char] = true;
    }

    return map;
  }

  // Backdoor for testing
  $.fn.alphanum.backdoorAlphaNum = function(inputString, settings){
    var combinedSettings = getCombinedSettingsAlphaNum(settings);

    return trimAlphaNum(inputString, combinedSettings);
  };

  $.fn.alphanum.backdoorNumeric = function(inputString, settings){
    var combinedSettings = getCombinedSettingsNum(settings);

    return trimNum(inputString, combinedSettings);
  };

  $.fn.alphanum.setNumericSeparators = function(settings) {

    if(settings.thousandsSeparator.length != 1)
      return;

    if(settings.decimalSeparator.length != 1)
      return;

    THOU_SEP = settings.thousandsSeparator;
    DEC_SEP = settings.decimalSeparator;
  };

})( jQuery );

/*eslint-disable */
//Include the 3rd party lib: jquery.caret.js


// Set caret position easily in jQuery
// Written by and Copyright of Luke Morton, 2011
// Licensed under MIT
(function ($) {
  // Behind the scenes method deals with browser
  // idiosyncrasies and such
  function caretTo(el, index) {
    if (el.createTextRange) {
      var range = el.createTextRange();
      range.move("character", index);
      range.select();
    } else if (el.selectionStart != null) {
      el.focus();
      el.setSelectionRange(index, index);
    }
  };

  // Another behind the scenes that collects the
  // current caret position for an element

  // TODO: Get working with Opera
  function caretPos(el) {
    if ("selection" in document) {
      var range = el.createTextRange();
      try {
        range.setEndPoint("EndToStart", document.selection.createRange());
      } catch (e) {
        // Catch IE failure here, return 0 like
        // other browsers
        return 0;
      }
      return range.text.length;
    } else if (el.selectionStart != null) {
      return el.selectionStart;
    }
  };

  // The following methods are queued under fx for more
  // flexibility when combining with $.fn.delay() and
  // jQuery effects.

  // Set caret to a particular index
  $.fn.alphanum_caret = function (index, offset) {
    if (typeof(index) === "undefined") {
      return caretPos(this.get(0));
    }

    return this.queue(function (next) {
      if (isNaN(index)) {
        var i = $(this).val().indexOf(index);

        if (offset === true) {
          i += index.length;
        } else if (typeof(offset) !== "undefined") {
          i += offset;
        }

        caretTo(this, i);
      } else {
        caretTo(this, index);
      }

      next();
    });
  };
}(jQuery));

/**********************************************************
* Selection Library
* Used to determine what text is highlighted in the textbox before a key is pressed.
* http://donejs.com/docs.html#!jQuery.fn.selection
* https://github.com/jupiterjs/jquerymx/blob/master/dom/selection/selection.js
***********************************************************/
(function(e){var t=function(e){return e.replace(/([a-z])([a-z]+)/gi,function(e,t,n){return t+n.toLowerCase()}).replace(/_/g,"")},n=function(e){return e.replace(/^([a-z]+)_TO_([a-z]+)/i,function(e,t,n){return n+"_TO_"+t})},r=function(e){return e?e.ownerDocument.defaultView||e.ownerDocument.parentWindow:window},i=function(t,n){var r=e.Range.current(t).clone(),i=e.Range(t).select(t);if(!r.overlaps(i)){return null}if(r.compare("START_TO_START",i)<1){startPos=0;r.move("START_TO_START",i)}else{fromElementToCurrent=i.clone();fromElementToCurrent.move("END_TO_START",r);startPos=fromElementToCurrent.toString().length}if(r.compare("END_TO_END",i)>=0){endPos=i.toString().length}else{endPos=startPos+r.toString().length}return{start:startPos,end:endPos}},s=function(t){var n=r(t);if(t.selectionStart!==undefined){if(document.activeElement&&document.activeElement!=t&&t.selectionStart==t.selectionEnd&&t.selectionStart==0){return{start:t.value.length,end:t.value.length}}return{start:t.selectionStart,end:t.selectionEnd}}else if(n.getSelection){return i(t,n)}else{try{if(t.nodeName.toLowerCase()=="input"){var s=r(t).document.selection.createRange(),o=t.createTextRange();o.setEndPoint("EndToStart",s);var u=o.text.length;return{start:u,end:u+s.text.length}}else{var a=i(t,n);if(!a){return a}var f=e.Range.current().clone(),l=f.clone().collapse().range,c=f.clone().collapse(false).range;l.moveStart("character",-1);c.moveStart("character",-1);if(a.startPos!=0&&l.text==""){a.startPos+=2}if(a.endPos!=0&&c.text==""){a.endPos+=2}return a}}catch(h){return{start:t.value.length,end:t.value.length}}}},o=function(e,t,n){var i=r(e);if(e.setSelectionRange){if(n===undefined){e.focus();e.setSelectionRange(t,t)}else{e.select();e.selectionStart=t;e.selectionEnd=n}}else if(e.createTextRange){var s=e.createTextRange();s.moveStart("character",t);n=n||t;s.moveEnd("character",n-e.value.length);s.select()}else if(i.getSelection){var o=i.document,u=i.getSelection(),f=o.createRange(),l=[t,n!==undefined?n:t];a([e],l);f.setStart(l[0].el,l[0].count);f.setEnd(l[1].el,l[1].count);u.removeAllRanges();u.addRange(f)}else if(i.document.body.createTextRange){var f=document.body.createTextRange();f.moveToElementText(e);f.collapse();f.moveStart("character",t);f.moveEnd("character",n!==undefined?n:t);f.select()}},u=function(e,t,n,r){if(typeof n[0]==="number"&&n[0]<t){n[0]={el:r,count:n[0]-e}}if(typeof n[1]==="number"&&n[1]<=t){n[1]={el:r,count:n[1]-e};}},a=function(e,t,n){var r,i;n=n||0;for(var s=0;e[s];s++){r=e[s];if(r.nodeType===3||r.nodeType===4){i=n;n+=r.nodeValue.length;u(i,n,t,r)}else if(r.nodeType!==8){n=a(r.childNodes,t,n)}}return n};jQuery.fn.selection=function(e,t){if(e!==undefined){return this.each(function(){o(this,e,t)})}else{return s(this[0])}};e.fn.selection.getCharElement=a})(jQuery);
/*eslint-enable */


/*!
 * Datepicker v1.0.6
 * https://fengyuanchen.github.io/datepicker
 *
 * Copyright 2014-present Chen Fengyuan
 * Released under the MIT license
 *
 * Date: 2019-01-19T09:15:49.236Z
 */
!function(t,e){"object"==typeof exports&&"undefined"!=typeof module?e(require("jquery")):"function"==typeof define&&define.amd?define(["jquery"],e):e((t=t||self).jQuery)}(this,function(D){"use strict";function s(t,e){for(var i=0;i<e.length;i++){var a=e[i];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(t,a.key,a)}}D=D&&D.hasOwnProperty("default")?D.default:D;var n={autoShow:!1,autoHide:!1,autoPick:!1,inline:!1,container:null,trigger:null,language:"",format:"mm/dd/yyyy",date:null,startDate:null,endDate:null,startView:0,weekStart:0,yearFirst:!1,yearSuffix:"",days:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],daysShort:["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],daysMin:["Do","Lu","Ma","Mi","Ju","Vi","Sa"],months:["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"],monthsShort:["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Set","Oct","Nov","Dic"],itemTag:"li",mutedClass:"muted",pickedClass:"picked",disabledClass:"disabled",highlightedClass:"highlighted",template:'<div class="datepicker-container"><div class="datepicker-panel" data-view="years picker"><ul><li data-view="years prev">&lsaquo;</li><li data-view="years current"></li><li data-view="years next">&rsaquo;</li></ul><ul data-view="years"></ul></div><div class="datepicker-panel" data-view="months picker"><ul><li data-view="year prev">&lsaquo;</li><li data-view="year current"></li><li data-view="year next">&rsaquo;</li></ul><ul data-view="months"></ul></div><div class="datepicker-panel" data-view="days picker"><ul><li data-view="month prev">&lsaquo;</li><li data-view="month current"></li><li data-view="month next">&rsaquo;</li></ul><ul data-view="week"></ul><ul data-view="days"></ul></div></div>',offset:10,zIndex:1e3,filter:null,show:null,hide:null,pick:null},t="undefined"!=typeof window,e=t?window:{},i=!!t&&"ontouchstart"in e.document.documentElement,c="datepicker",r="click.".concat(c),h="focus.".concat(c),o="hide.".concat(c),l="keyup.".concat(c),d="pick.".concat(c),a="resize.".concat(c),u="scroll.".concat(c),p="show.".concat(c),f="touchstart.".concat(c),g="".concat(c,"-hide"),y={},m=0,v=1,w=2,k=Object.prototype.toString;function b(t){return"string"==typeof t}var C=Number.isNaN||e.isNaN;function $(t){return"number"==typeof t&&!C(t)}function x(t){return void 0===t}function F(t){return"date"===(e=t,k.call(e).slice(8,-1).toLowerCase())&&!C(t.getTime());var e}function M(a,s){for(var t=arguments.length,n=new Array(2<t?t-2:0),e=2;e<t;e++)n[e-2]=arguments[e];return function(){for(var t=arguments.length,e=new Array(t),i=0;i<t;i++)e[i]=arguments[i];return a.apply(s,n.concat(e))}}function Y(t){return'[data-view="'.concat(t,'"]')}function G(t,e){return[31,(i=t,i%4==0&&i%100!=0||i%400==0?29:28),31,30,31,30,31,31,30,31,30,31][e];var i}function V(t,e,i){return Math.min(i,G(t,e))}var T=/(y|m|d)+/g;function S(t){var e=1<arguments.length&&void 0!==arguments[1]?arguments[1]:1,i=String(Math.abs(t)),a=i.length,s="";for(t<0&&(s+="-");a<e;)a+=1,s+="0";return s+i}var I=/\d+/g,P={show:function(){this.built||this.build(),this.shown||this.trigger(p).isDefaultPrevented()||(this.shown=!0,this.$picker.removeClass(g).on(r,D.proxy(this.click,this)),this.showView(this.options.startView),this.inline||(this.$scrollParent.on(u,D.proxy(this.place,this)),D(window).on(a,this.onResize=M(this.place,this)),D(document).on(r,this.onGlobalClick=M(this.globalClick,this)),D(document).on(l,this.onGlobalKeyup=M(this.globalKeyup,this)),i&&D(document).on(f,this.onTouchStart=M(this.touchstart,this)),this.place()))},hide:function(){this.shown&&(this.trigger(o).isDefaultPrevented()||(this.shown=!1,this.$picker.addClass(g).off(r,this.click),this.inline||(this.$scrollParent.off(u,this.place),D(window).off(a,this.onResize),D(document).off(r,this.onGlobalClick),D(document).off(l,this.onGlobalKeyup),i&&D(document).off(f,this.onTouchStart))))},toggle:function(){this.shown?this.hide():this.show()},update:function(){var t=this.getValue();t!==this.oldValue&&(this.setDate(t,!0),this.oldValue=t)},pick:function(t){var e=this.$element,i=this.date;this.trigger(d,{view:t||"",date:i}).isDefaultPrevented()||(i=this.formatDate(this.date),this.setValue(i),this.isInput&&(e.trigger("input"),e.trigger("change")))},reset:function(){this.setDate(this.initialDate,!0),this.setValue(this.initialValue),this.shown&&this.showView(this.options.startView)},getMonthName:function(t,e){var i=this.options,a=i.monthsShort,s=i.months;return D.isNumeric(t)?t=Number(t):x(e)&&(e=t),!0===e&&(s=a),s[$(t)?t:this.date.getMonth()]},getDayName:function(t,e,i){var a=this.options,s=a.days;return D.isNumeric(t)?t=Number(t):(x(i)&&(i=e),x(e)&&(e=t)),i?s=a.daysMin:e&&(s=a.daysShort),s[$(t)?t:this.date.getDay()]},getDate:function(t){var e=this.date;return t?this.formatDate(e):new Date(e)},setDate:function(t,e){var i=this.options.filter;if(F(t)||b(t)){if(t=this.parseDate(t),D.isFunction(i)&&!1===i.call(this.$element,t,"day"))return;this.date=t,this.viewDate=new Date(t),e||this.pick(),this.built&&this.render()}},setStartDate:function(t){F(t)||b(t)?this.startDate=this.parseDate(t):this.startDate=null,this.built&&this.render()},setEndDate:function(t){F(t)||b(t)?this.endDate=this.parseDate(t):this.endDate=null,this.built&&this.render()},parseDate:function(a){var s=this.format,t=[];return F(a)||(b(a)&&(t=a.match(I)||[]),F(a=a?new Date(a):new Date)||(a=new Date),t.length===s.parts.length&&D.each(t,function(t,e){var i=parseInt(e,10);switch(s.parts[t]){case"dd":case"d":a.setDate(i);break;case"mm":case"m":a.setMonth(i-1);break;case"yy":a.setFullYear(2e3+i);break;case"yyyy":a.setFullYear(2===e.length?2e3+i:i)}})),new Date(a.getFullYear(),a.getMonth(),a.getDate())},formatDate:function(t){var e=this.format,i="";if(F(t)){var a=t.getFullYear(),s=t.getMonth(),n=t.getDate(),r={d:n,dd:S(n,2),m:s+1,mm:S(s+1,2),yy:String(a).substring(2),yyyy:S(a,4)};i=e.source,D.each(e.parts,function(t,e){i=i.replace(e,r[e])})}return i},destroy:function(){this.unbind(),this.unbuild(),this.$element.removeData(c)}},N={click:function(t){var e=D(t.target),i=this.options,a=this.date,s=this.viewDate,n=this.format;if(t.stopPropagation(),t.preventDefault(),!e.hasClass("disabled")){var r=e.data("view"),h=s.getFullYear(),o=s.getMonth(),l=s.getDate();switch(r){case"years prev":case"years next":h="years prev"===r?h-10:h+10,s.setFullYear(h),s.setDate(V(h,o,l)),this.renderYears();break;case"year prev":case"year next":h="year prev"===r?h-1:h+1,s.setFullYear(h),s.setDate(V(h,o,l)),this.renderMonths();break;case"year current":n.hasYear&&this.showView(w);break;case"year picked":n.hasMonth?this.showView(v):(e.addClass(i.pickedClass).siblings().removeClass(i.pickedClass),this.hideView()),this.pick("year");break;case"year":h=parseInt(e.text(),10),a.setFullYear(h),a.setDate(V(h,o,l)),s.setFullYear(h),s.setDate(V(h,o,l)),n.hasMonth?this.showView(v):(e.addClass(i.pickedClass).siblings().removeClass(i.pickedClass),this.hideView()),this.pick("year");break;case"month prev":case"month next":(o="month prev"===r?o-1:o+1)<0?(h-=1,o+=12):11<o&&(h+=1,o-=12),s.setFullYear(h),s.setDate(V(h,o,l)),s.setMonth(o),this.renderDays();break;case"month current":n.hasMonth&&this.showView(v);break;case"month picked":n.hasDay?this.showView(m):(e.addClass(i.pickedClass).siblings().removeClass(i.pickedClass),this.hideView()),this.pick("month");break;case"month":o=D.inArray(e.text(),i.monthsShort),a.setFullYear(h),a.setDate(V(h,o,l)),a.setMonth(o),s.setFullYear(h),s.setDate(V(h,o,l)),s.setMonth(o),n.hasDay?this.showView(m):(e.addClass(i.pickedClass).siblings().removeClass(i.pickedClass),this.hideView()),this.pick("month");break;case"day prev":case"day next":case"day":"day prev"===r?o-=1:"day next"===r&&(o+=1),l=parseInt(e.text(),10),a.setFullYear(h),a.setMonth(o),a.setDate(l),s.setFullYear(h),s.setMonth(o),s.setDate(l),this.renderDays(),"day"===r&&this.hideView(),this.pick("day");break;case"day picked":this.hideView(),this.pick("day")}}},globalClick:function(t){for(var e=t.target,i=this.element,a=this.$trigger[0],s=!0;e!==document;){if(e===a||e===i){s=!1;break}e=e.parentNode}s&&this.hide()},keyup:function(){this.update()},globalKeyup:function(t){var e=t.target,i=t.key,a=t.keyCode;this.isInput&&e!==this.element&&this.shown&&("Tab"===i||9===a)&&this.hide()},touchstart:function(t){var e=t.target;this.isInput&&e!==this.element&&!D.contains(this.$picker[0],e)&&(this.hide(),this.element.blur())}},j={render:function(){this.renderYears(),this.renderMonths(),this.renderDays()},renderWeek:function(){var i=this,a=[],t=this.options,e=t.weekStart,s=t.daysMin;e=parseInt(e,10)%7,s=s.slice(e).concat(s.slice(0,e)),D.each(s,function(t,e){a.push(i.createItem({text:e}))}),this.$week.html(a.join(""))},renderYears:function(){var t,e=this.options,i=this.startDate,a=this.endDate,s=e.disabledClass,n=e.filter,r=e.yearSuffix,h=this.viewDate.getFullYear(),o=(new Date).getFullYear(),l=this.date.getFullYear(),c=[],d=!1,u=!1;for(t=-5;t<=6;t+=1){var p=new Date(h+t,1,1),f=!1;i&&(f=p.getFullYear()<i.getFullYear(),-5===t&&(d=f)),!f&&a&&(f=p.getFullYear()>a.getFullYear(),6===t&&(u=f)),!f&&n&&(f=!1===n.call(this.$element,p,"year"));var g=h+t===l,y=g?"year picked":"year";c.push(this.createItem({picked:g,disabled:f,text:h+t,view:f?"year disabled":y,highlighted:p.getFullYear()===o}))}this.$yearsPrev.toggleClass(s,d),this.$yearsNext.toggleClass(s,u),this.$yearsCurrent.toggleClass(s,!0).html("".concat(h+-5+r," - ").concat(h+6).concat(r)),this.$years.html(c.join(""))},renderMonths:function(){var t,e=this.options,i=this.startDate,a=this.endDate,s=this.viewDate,n=e.disabledClass||"",r=e.monthsShort,h=D.isFunction(e.filter)&&e.filter,o=s.getFullYear(),l=new Date,c=l.getFullYear(),d=l.getMonth(),u=this.date.getFullYear(),p=this.date.getMonth(),f=[],g=!1,y=!1;for(t=0;t<=11;t+=1){var m=new Date(o,t,1),v=!1;i&&(v=(g=m.getFullYear()===i.getFullYear())&&m.getMonth()<i.getMonth()),!v&&a&&(v=(y=m.getFullYear()===a.getFullYear())&&m.getMonth()>a.getMonth()),!v&&h&&(v=!1===h.call(this.$element,m,"month"));var w=o===u&&t===p,k=w?"month picked":"month";f.push(this.createItem({disabled:v,picked:w,highlighted:o===c&&m.getMonth()===d,index:t,text:r[t],view:v?"month disabled":k}))}this.$yearPrev.toggleClass(n,g),this.$yearNext.toggleClass(n,y),this.$yearCurrent.toggleClass(n,g&&y).html(o+e.yearSuffix||""),this.$months.html(f.join(""))},renderDays:function(){var t,e,i,a=this.$element,s=this.options,n=this.startDate,r=this.endDate,h=this.viewDate,o=this.date,l=s.disabledClass,c=s.filter,d=s.months,u=s.weekStart,p=s.yearSuffix,f=h.getFullYear(),g=h.getMonth(),y=new Date,m=y.getFullYear(),v=y.getMonth(),w=y.getDate(),k=o.getFullYear(),D=o.getMonth(),b=o.getDate(),C=[],$=f,x=g,F=!1;0===g?($-=1,x=11):x-=1,t=G($,x);var M=new Date(f,g,1);for((i=M.getDay()-parseInt(u,10)%7)<=0&&(i+=7),n&&(F=M.getTime()<=n.getTime()),e=t-(i-1);e<=t;e+=1){var Y=new Date($,x,e),V=!1;n&&(V=Y.getTime()<n.getTime()),!V&&c&&(V=!1===c.call(a,Y,"day")),C.push(this.createItem({disabled:V,highlighted:$===m&&x===v&&Y.getDate()===w,muted:!0,picked:$===k&&x===D&&e===b,text:e,view:"day prev"}))}var T=[],S=f,I=g,P=!1;11===g?(S+=1,I=0):I+=1,t=G(f,g),i=42-(C.length+t);var N=new Date(f,g,t);for(r&&(P=N.getTime()>=r.getTime()),e=1;e<=i;e+=1){var j=new Date(S,I,e),q=S===k&&I===D&&e===b,A=!1;r&&(A=j.getTime()>r.getTime()),!A&&c&&(A=!1===c.call(a,j,"day")),T.push(this.createItem({disabled:A,picked:q,highlighted:S===m&&I===v&&j.getDate()===w,muted:!0,text:e,view:"day next"}))}var O=[];for(e=1;e<=t;e+=1){var W=new Date(f,g,e),z=!1;n&&(z=W.getTime()<n.getTime()),!z&&r&&(z=W.getTime()>r.getTime()),!z&&c&&(z=!1===c.call(a,W,"day"));var J=f===k&&g===D&&e===b,E=J?"day picked":"day";O.push(this.createItem({disabled:z,picked:J,highlighted:f===m&&g===v&&W.getDate()===w,text:e,view:z?"day disabled":E}))}this.$monthPrev.toggleClass(l,F),this.$monthNext.toggleClass(l,P),this.$monthCurrent.toggleClass(l,F&&P).html(s.yearFirst?"".concat(f+p," ").concat(d[g]):"".concat(d[g]," ").concat(f).concat(p)),this.$days.html(C.join("")+O.join("")+T.join(""))}},q="".concat(c,"-top-left"),A="".concat(c,"-top-right"),O="".concat(c,"-bottom-left"),W="".concat(c,"-bottom-right"),z=[q,A,O,W].join(" "),J=function(){function i(t){var e=1<arguments.length&&void 0!==arguments[1]?arguments[1]:{};!function(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}(this,i),this.$element=D(t),this.element=t,this.options=D.extend({},n,y[e.language],D.isPlainObject(e)&&e),this.$scrollParent=function(t){var e=1<arguments.length&&void 0!==arguments[1]&&arguments[1],i=D(t),a=i.css("position"),s="absolute"===a,n=e?/auto|scroll|hidden/:/auto|scroll/,r=i.parents().filter(function(t,e){var i=D(e);return(!s||"static"!==i.css("position"))&&n.test(i.css("overflow")+i.css("overflow-y")+i.css("overflow-x"))}).eq(0);return"fixed"!==a&&r.length?r:D(t.ownerDocument||document)}(t,!0),this.built=!1,this.shown=!1,this.isInput=!1,this.inline=!1,this.initialValue="",this.initialDate=null,this.startDate=null,this.endDate=null,this.init()}var t,e,a;return t=i,a=[{key:"setDefaults",value:function(){var t=0<arguments.length&&void 0!==arguments[0]?arguments[0]:{};D.extend(n,y[t.language],D.isPlainObject(t)&&t)}}],(e=[{key:"init",value:function(){var t=this.$element,e=this.options,i=e.startDate,a=e.endDate,s=e.date;this.$trigger=D(e.trigger),this.isInput=t.is("input")||t.is("textarea"),this.inline=e.inline&&(e.container||!this.isInput),this.format=function(i){var t=String(i).toLowerCase(),e=t.match(T);if(!e||0===e.length)throw new Error("Invalid date format.");return i={source:t,parts:e},D.each(e,function(t,e){switch(e){case"dd":case"d":i.hasDay=!0;break;case"mm":case"m":i.hasMonth=!0;break;case"yyyy":case"yy":i.hasYear=!0}}),i}(e.format);var n=this.getValue();this.initialValue=n,this.oldValue=n,s=this.parseDate(s||n),i&&(i=this.parseDate(i),s.getTime()<i.getTime()&&(s=new Date(i)),this.startDate=i),a&&(a=this.parseDate(a),i&&a.getTime()<i.getTime()&&(a=new Date(i)),s.getTime()>a.getTime()&&(s=new Date(a)),this.endDate=a),this.date=s,this.viewDate=new Date(s),this.initialDate=new Date(this.date),this.bind(),(e.autoShow||this.inline)&&this.show(),e.autoPick&&this.pick()}},{key:"build",value:function(){if(!this.built){this.built=!0;var t=this.$element,e=this.options,i=D(e.template);this.$picker=i,this.$week=i.find(Y("week")),this.$yearsPicker=i.find(Y("years picker")),this.$yearsPrev=i.find(Y("years prev")),this.$yearsNext=i.find(Y("years next")),this.$yearsCurrent=i.find(Y("years current")),this.$years=i.find(Y("years")),this.$monthsPicker=i.find(Y("months picker")),this.$yearPrev=i.find(Y("year prev")),this.$yearNext=i.find(Y("year next")),this.$yearCurrent=i.find(Y("year current")),this.$months=i.find(Y("months")),this.$daysPicker=i.find(Y("days picker")),this.$monthPrev=i.find(Y("month prev")),this.$monthNext=i.find(Y("month next")),this.$monthCurrent=i.find(Y("month current")),this.$days=i.find(Y("days")),this.inline?D(e.container||t).append(i.addClass("".concat(c,"-inline"))):(D(document.body).append(i.addClass("".concat(c,"-dropdown"))),i.addClass(g).css({zIndex:parseInt(e.zIndex,10)})),this.renderWeek()}}},{key:"unbuild",value:function(){this.built&&(this.built=!1,this.$picker.remove())}},{key:"bind",value:function(){var t=this.options,e=this.$element;D.isFunction(t.show)&&e.on(p,t.show),D.isFunction(t.hide)&&e.on(o,t.hide),D.isFunction(t.pick)&&e.on(d,t.pick),this.isInput&&e.on(l,D.proxy(this.keyup,this)),this.inline||(t.trigger?this.$trigger.on(r,D.proxy(this.toggle,this)):this.isInput?e.on(h,D.proxy(this.show,this)):e.on(r,D.proxy(this.show,this)))}},{key:"unbind",value:function(){var t=this.$element,e=this.options;D.isFunction(e.show)&&t.off(p,e.show),D.isFunction(e.hide)&&t.off(o,e.hide),D.isFunction(e.pick)&&t.off(d,e.pick),this.isInput&&t.off(l,this.keyup),this.inline||(e.trigger?this.$trigger.off(r,this.toggle):this.isInput?t.off(h,this.show):t.off(r,this.show))}},{key:"showView",value:function(t){var e=this.$yearsPicker,i=this.$monthsPicker,a=this.$daysPicker,s=this.format;if(s.hasYear||s.hasMonth||s.hasDay)switch(Number(t)){case w:i.addClass(g),a.addClass(g),s.hasYear?(this.renderYears(),e.removeClass(g),this.place()):this.showView(m);break;case v:e.addClass(g),a.addClass(g),s.hasMonth?(this.renderMonths(),i.removeClass(g),this.place()):this.showView(w);break;default:e.addClass(g),i.addClass(g),s.hasDay?(this.renderDays(),a.removeClass(g),this.place()):this.showView(v)}}},{key:"hideView",value:function(){!this.inline&&this.options.autoHide&&this.hide()}},{key:"place",value:function(){if(!this.inline){var t=this.$element,e=this.options,i=this.$picker,a=D(document).outerWidth(),s=D(document).outerHeight(),n=t.outerWidth(),r=t.outerHeight(),h=i.width(),o=i.height(),l=t.offset(),c=l.left,d=l.top,u=parseFloat(e.offset),p=q;C(u)&&(u=10),o<d&&s<d+r+o?(d-=o+u,p=O):d+=r+u,a<c+h&&(c+=n-h,p=p.replace("left","right")),i.removeClass(z).addClass(p).css({top:d,left:c})}}},{key:"trigger",value:function(t,e){var i=D.Event(t,e);return this.$element.trigger(i),i}},{key:"createItem",value:function(t){var e=this.options,i=e.itemTag,a={text:"",view:"",muted:!1,picked:!1,disabled:!1,highlighted:!1},s=[];return D.extend(a,t),a.muted&&s.push(e.mutedClass),a.highlighted&&s.push(e.highlightedClass),a.picked&&s.push(e.pickedClass),a.disabled&&s.push(e.disabledClass),"<".concat(i,' class="').concat(s.join(" "),'" data-view="').concat(a.view,'">').concat(a.text,"</").concat(i,">")}},{key:"getValue",value:function(){var t=this.$element;return this.isInput?t.val():t.text()}},{key:"setValue",value:function(){var t=0<arguments.length&&void 0!==arguments[0]?arguments[0]:"",e=this.$element;this.isInput?e.val(t):this.inline&&!this.options.container||e.text(t)}}])&&s(t.prototype,e),a&&s(t,a),i}();if(D.extend&&D.extend(J.prototype,j,N,P),D.fn){var E=D.fn.datepicker;D.fn.datepicker=function(h){for(var t=arguments.length,o=new Array(1<t?t-1:0),e=1;e<t;e++)o[e-1]=arguments[e];var l;return this.each(function(t,e){var i=D(e),a="destroy"===h,s=i.data(c);if(!s){if(a)return;var n=D.extend({},i.data(),D.isPlainObject(h)&&h);s=new J(e,n),i.data(c,s)}if(b(h)){var r=s[h];D.isFunction(r)&&(l=r.apply(s,o),a&&i.removeData(c))}}),x(l)?this:l},D.fn.datepicker.Constructor=J,D.fn.datepicker.languages=y,D.fn.datepicker.setDefaults=J.setDefaults,D.fn.datepicker.noConflict=function(){return D.fn.datepicker=E,this}}});

/*!
 * cleave.js - 1.5.3
 * https://github.com/nosir/cleave.js
 * Apache License Version 2.0
 *
 * Copyright (C) 2012-2019 Max Huang https://github.com/nosir/
 */
!function(e,t){"object"==typeof exports&&"object"==typeof module?module.exports=t():"function"==typeof define&&define.amd?define([],t):"object"==typeof exports?exports.Cleave=t():e.Cleave=t()}(this,function(){return function(e){function t(i){if(r[i])return r[i].exports;var n=r[i]={exports:{},id:i,loaded:!1};return e[i].call(n.exports,n,n.exports,t),n.loaded=!0,n.exports}var r={};return t.m=e,t.c=r,t.p="",t(0)}([function(e,t,r){(function(t){"use strict";var i=function(e,t){var r=this,n=!1;if("string"==typeof e?(r.element=document.querySelector(e),n=document.querySelectorAll(e).length>1):"undefined"!=typeof e.length&&e.length>0?(r.element=e[0],n=e.length>1):r.element=e,!r.element)throw new Error("[cleave.js] Please check the element");if(n)try{console.warn("[cleave.js] Multiple input fields matched, cleave.js will only take the first one.")}catch(a){}t.initValue=r.element.value,r.properties=i.DefaultProperties.assign({},t),r.init()};i.prototype={init:function(){var e=this,t=e.properties;return t.numeral||t.phone||t.creditCard||t.time||t.date||0!==t.blocksLength||t.prefix?(t.maxLength=i.Util.getMaxLength(t.blocks),e.isAndroid=i.Util.isAndroid(),e.lastInputValue="",e.onChangeListener=e.onChange.bind(e),e.onKeyDownListener=e.onKeyDown.bind(e),e.onFocusListener=e.onFocus.bind(e),e.onCutListener=e.onCut.bind(e),e.onCopyListener=e.onCopy.bind(e),e.element.addEventListener("input",e.onChangeListener),e.element.addEventListener("keydown",e.onKeyDownListener),e.element.addEventListener("focus",e.onFocusListener),e.element.addEventListener("cut",e.onCutListener),e.element.addEventListener("copy",e.onCopyListener),e.initPhoneFormatter(),e.initDateFormatter(),e.initTimeFormatter(),e.initNumeralFormatter(),void((t.initValue||t.prefix&&!t.noImmediatePrefix)&&e.onInput(t.initValue))):void e.onInput(t.initValue)},initNumeralFormatter:function(){var e=this,t=e.properties;t.numeral&&(t.numeralFormatter=new i.NumeralFormatter(t.numeralDecimalMark,t.numeralIntegerScale,t.numeralDecimalScale,t.numeralThousandsGroupStyle,t.numeralPositiveOnly,t.stripLeadingZeroes,t.prefix,t.signBeforePrefix,t.delimiter))},initTimeFormatter:function(){var e=this,t=e.properties;t.time&&(t.timeFormatter=new i.TimeFormatter(t.timePattern,t.timeFormat),t.blocks=t.timeFormatter.getBlocks(),t.blocksLength=t.blocks.length,t.maxLength=i.Util.getMaxLength(t.blocks))},initDateFormatter:function(){var e=this,t=e.properties;t.date&&(t.dateFormatter=new i.DateFormatter(t.datePattern,t.dateMin,t.dateMax),t.blocks=t.dateFormatter.getBlocks(),t.blocksLength=t.blocks.length,t.maxLength=i.Util.getMaxLength(t.blocks))},initPhoneFormatter:function(){var e=this,t=e.properties;if(t.phone)try{t.phoneFormatter=new i.PhoneFormatter(new t.root.Cleave.AsYouTypeFormatter(t.phoneRegionCode),t.delimiter)}catch(r){throw new Error("[cleave.js] Please include phone-type-formatter.{country}.js lib")}},onKeyDown:function(e){var t=this,r=t.properties,n=e.which||e.keyCode,a=i.Util,o=t.element.value;t.hasBackspaceSupport=t.hasBackspaceSupport||8===n,!t.hasBackspaceSupport&&a.isAndroidBackspaceKeydown(t.lastInputValue,o)&&(n=8),t.lastInputValue=o;var l=a.getPostDelimiter(o,r.delimiter,r.delimiters);8===n&&l?r.postDelimiterBackspace=l:r.postDelimiterBackspace=!1},onChange:function(){this.onInput(this.element.value)},onFocus:function(){var e=this,t=e.properties;i.Util.fixPrefixCursor(e.element,t.prefix,t.delimiter,t.delimiters)},onCut:function(e){i.Util.checkFullSelection(this.element.value)&&(this.copyClipboardData(e),this.onInput(""))},onCopy:function(e){i.Util.checkFullSelection(this.element.value)&&this.copyClipboardData(e)},copyClipboardData:function(e){var t=this,r=t.properties,n=i.Util,a=t.element.value,o="";o=r.copyDelimiter?a:n.stripDelimiters(a,r.delimiter,r.delimiters);try{e.clipboardData?e.clipboardData.setData("Text",o):window.clipboardData.setData("Text",o),e.preventDefault()}catch(l){}},onInput:function(e){var t=this,r=t.properties,n=i.Util,a=n.getPostDelimiter(e,r.delimiter,r.delimiters);return r.numeral||!r.postDelimiterBackspace||a||(e=n.headStr(e,e.length-r.postDelimiterBackspace.length)),r.phone?(!r.prefix||r.noImmediatePrefix&&!e.length?r.result=r.phoneFormatter.format(e):r.result=r.prefix+r.phoneFormatter.format(e).slice(r.prefix.length),void t.updateValueState()):r.numeral?(r.prefix&&r.noImmediatePrefix&&0===e.length?r.result="":r.result=r.numeralFormatter.format(e),void t.updateValueState()):(r.date&&(e=r.dateFormatter.getValidatedDate(e)),r.time&&(e=r.timeFormatter.getValidatedTime(e)),e=n.stripDelimiters(e,r.delimiter,r.delimiters),e=n.getPrefixStrippedValue(e,r.prefix,r.prefixLength,r.result,r.delimiter,r.delimiters,r.noImmediatePrefix),e=r.numericOnly?n.strip(e,/[^\d]/g):e,e=r.uppercase?e.toUpperCase():e,e=r.lowercase?e.toLowerCase():e,!r.prefix||r.noImmediatePrefix&&!e.length||(e=r.prefix+e,0!==r.blocksLength)?(r.creditCard&&t.updateCreditCardPropsByValue(e),e=n.headStr(e,r.maxLength),r.result=n.getFormattedValue(e,r.blocks,r.blocksLength,r.delimiter,r.delimiters,r.delimiterLazyShow),void t.updateValueState()):(r.result=e,void t.updateValueState()))},updateCreditCardPropsByValue:function(e){var t,r=this,n=r.properties,a=i.Util;a.headStr(n.result,4)!==a.headStr(e,4)&&(t=i.CreditCardDetector.getInfo(e,n.creditCardStrictMode),n.blocks=t.blocks,n.blocksLength=n.blocks.length,n.maxLength=a.getMaxLength(n.blocks),n.creditCardType!==t.type&&(n.creditCardType=t.type,n.onCreditCardTypeChanged.call(r,n.creditCardType)))},updateValueState:function(){var e=this,t=i.Util,r=e.properties;if(e.element){var n=e.element.selectionEnd,a=e.element.value,o=r.result;if(n=t.getNextCursorPosition(n,a,o,r.delimiter,r.delimiters),e.isAndroid)return void window.setTimeout(function(){e.element.value=o,t.setSelection(e.element,n,r.document,!1),e.callOnValueChanged()},1);e.element.value=o,t.setSelection(e.element,n,r.document,!1),e.callOnValueChanged()}},callOnValueChanged:function(){var e=this,t=e.properties;t.onValueChanged.call(e,{target:{value:t.result,rawValue:e.getRawValue()}})},setPhoneRegionCode:function(e){var t=this,r=t.properties;r.phoneRegionCode=e,t.initPhoneFormatter(),t.onChange()},setRawValue:function(e){var t=this,r=t.properties;e=void 0!==e&&null!==e?e.toString():"",r.numeral&&(e=e.replace(".",r.numeralDecimalMark)),r.postDelimiterBackspace=!1,t.element.value=e,t.onInput(e)},getRawValue:function(){var e=this,t=e.properties,r=i.Util,n=e.element.value;return t.rawValueTrimPrefix&&(n=r.getPrefixStrippedValue(n,t.prefix,t.prefixLength,t.result,t.delimiter,t.delimiters)),n=t.numeral?t.numeralFormatter.getRawValue(n):r.stripDelimiters(n,t.delimiter,t.delimiters)},getISOFormatDate:function(){var e=this,t=e.properties;return t.date?t.dateFormatter.getISOFormatDate():""},getISOFormatTime:function(){var e=this,t=e.properties;return t.time?t.timeFormatter.getISOFormatTime():""},getFormattedValue:function(){return this.element.value},destroy:function(){var e=this;e.element.removeEventListener("input",e.onChangeListener),e.element.removeEventListener("keydown",e.onKeyDownListener),e.element.removeEventListener("focus",e.onFocusListener),e.element.removeEventListener("cut",e.onCutListener),e.element.removeEventListener("copy",e.onCopyListener)},toString:function(){return"[Cleave Object]"}},i.NumeralFormatter=r(1),i.DateFormatter=r(2),i.TimeFormatter=r(3),i.PhoneFormatter=r(4),i.CreditCardDetector=r(5),i.Util=r(6),i.DefaultProperties=r(7),("object"==typeof t&&t?t:window).Cleave=i,e.exports=i}).call(t,function(){return this}())},function(e,t){"use strict";var r=function(e,t,i,n,a,o,l,s,c){var u=this;u.numeralDecimalMark=e||".",u.numeralIntegerScale=t>0?t:0,u.numeralDecimalScale=i>=0?i:2,u.numeralThousandsGroupStyle=n||r.groupStyle.thousand,u.numeralPositiveOnly=!!a,u.stripLeadingZeroes=o!==!1,u.prefix=l||""===l?l:"",u.signBeforePrefix=!!s,u.delimiter=c||""===c?c:",",u.delimiterRE=c?new RegExp("\\"+c,"g"):""};r.groupStyle={thousand:"thousand",lakh:"lakh",wan:"wan",none:"none"},r.prototype={getRawValue:function(e){return e.replace(this.delimiterRE,"").replace(this.numeralDecimalMark,".")},format:function(e){var t,i,n,a,o=this,l="";switch(e=e.replace(/[A-Za-z]/g,"").replace(o.numeralDecimalMark,"M").replace(/[^\dM-]/g,"").replace(/^\-/,"N").replace(/\-/g,"").replace("N",o.numeralPositiveOnly?"":"-").replace("M",o.numeralDecimalMark),o.stripLeadingZeroes&&(e=e.replace(/^(-)?0+(?=\d)/,"$1")),i="-"===e.slice(0,1)?"-":"",n="undefined"!=typeof o.prefix?o.signBeforePrefix?i+o.prefix:o.prefix+i:i,a=e,e.indexOf(o.numeralDecimalMark)>=0&&(t=e.split(o.numeralDecimalMark),a=t[0],l=o.numeralDecimalMark+t[1].slice(0,o.numeralDecimalScale)),"-"===i&&(a=a.slice(1)),o.numeralIntegerScale>0&&(a=a.slice(0,o.numeralIntegerScale)),o.numeralThousandsGroupStyle){case r.groupStyle.lakh:a=a.replace(/(\d)(?=(\d\d)+\d$)/g,"$1"+o.delimiter);break;case r.groupStyle.wan:a=a.replace(/(\d)(?=(\d{4})+$)/g,"$1"+o.delimiter);break;case r.groupStyle.thousand:a=a.replace(/(\d)(?=(\d{3})+$)/g,"$1"+o.delimiter)}return n+a.toString()+(o.numeralDecimalScale>0?l.toString():"")}},e.exports=r},function(e,t){"use strict";var r=function(e,t,r){var i=this;i.date=[],i.blocks=[],i.datePattern=e,i.dateMin=t.split("-").reverse().map(function(e){return parseInt(e,10)}),2===i.dateMin.length&&i.dateMin.unshift(0),i.dateMax=r.split("-").reverse().map(function(e){return parseInt(e,10)}),2===i.dateMax.length&&i.dateMax.unshift(0),i.initBlocks()};r.prototype={initBlocks:function(){var e=this;e.datePattern.forEach(function(t){"Y"===t?e.blocks.push(4):e.blocks.push(2)})},getISOFormatDate:function(){var e=this,t=e.date;return t[2]?t[2]+"-"+e.addLeadingZero(t[1])+"-"+e.addLeadingZero(t[0]):""},getBlocks:function(){return this.blocks},getValidatedDate:function(e){var t=this,r="";return e=e.replace(/[^\d]/g,""),t.blocks.forEach(function(i,n){if(e.length>0){var a=e.slice(0,i),o=a.slice(0,1),l=e.slice(i);switch(t.datePattern[n]){case"d":"00"===a?a="01":parseInt(o,10)>3?a="0"+o:parseInt(a,10)>31&&(a="31");break;case"m":"00"===a?a="01":parseInt(o,10)>1?a="0"+o:parseInt(a,10)>12&&(a="12")}r+=a,e=l}}),this.getFixedDateString(r)},getFixedDateString:function(e){var t,r,i,n=this,a=n.datePattern,o=[],l=0,s=0,c=0,u=0,d=0,m=0,p=!1;4===e.length&&"y"!==a[0].toLowerCase()&&"y"!==a[1].toLowerCase()&&(u="d"===a[0]?0:2,d=2-u,t=parseInt(e.slice(u,u+2),10),r=parseInt(e.slice(d,d+2),10),o=this.getFixedDate(t,r,0)),8===e.length&&(a.forEach(function(e,t){switch(e){case"d":l=t;break;case"m":s=t;break;default:c=t}}),m=2*c,u=l<=c?2*l:2*l+2,d=s<=c?2*s:2*s+2,t=parseInt(e.slice(u,u+2),10),r=parseInt(e.slice(d,d+2),10),i=parseInt(e.slice(m,m+4),10),p=4===e.slice(m,m+4).length,o=this.getFixedDate(t,r,i)),4!==e.length||"y"!==a[0]&&"y"!==a[1]||(d="m"===a[0]?0:2,m=2-d,r=parseInt(e.slice(d,d+2),10),i=parseInt(e.slice(m,m+2),10),p=2===e.slice(m,m+2).length,o=[0,r,i]),6!==e.length||"Y"!==a[0]&&"Y"!==a[1]||(d="m"===a[0]?0:4,m=2-.5*d,r=parseInt(e.slice(d,d+2),10),i=parseInt(e.slice(m,m+4),10),p=4===e.slice(m,m+4).length,o=[0,r,i]),o=n.getRangeFixedDate(o),n.date=o;var h=0===o.length?e:a.reduce(function(e,t){switch(t){case"d":return e+(0===o[0]?"":n.addLeadingZero(o[0]));case"m":return e+(0===o[1]?"":n.addLeadingZero(o[1]));case"y":return e+(p?n.addLeadingZeroForYear(o[2],!1):"");case"Y":return e+(p?n.addLeadingZeroForYear(o[2],!0):"")}},"");return h},getRangeFixedDate:function(e){var t=this,r=t.datePattern,i=t.dateMin||[],n=t.dateMax||[];return!e.length||i.length<3&&n.length<3?e:r.find(function(e){return"y"===e.toLowerCase()})&&0===e[2]?e:n.length&&(n[2]<e[2]||n[2]===e[2]&&(n[1]<e[1]||n[1]===e[1]&&n[0]<e[0]))?n:i.length&&(i[2]>e[2]||i[2]===e[2]&&(i[1]>e[1]||i[1]===e[1]&&i[0]>e[0]))?i:e},getFixedDate:function(e,t,r){return e=Math.min(e,31),t=Math.min(t,12),r=parseInt(r||0,10),(t<7&&t%2===0||t>8&&t%2===1)&&(e=Math.min(e,2===t?this.isLeapYear(r)?29:28:30)),[e,t,r]},isLeapYear:function(e){return e%4===0&&e%100!==0||e%400===0},addLeadingZero:function(e){return(e<10?"0":"")+e},addLeadingZeroForYear:function(e,t){return t?(e<10?"000":e<100?"00":e<1e3?"0":"")+e:(e<10?"0":"")+e}},e.exports=r},function(e,t){"use strict";var r=function(e,t){var r=this;r.time=[],r.blocks=[],r.timePattern=e,r.timeFormat=t,r.initBlocks()};r.prototype={initBlocks:function(){var e=this;e.timePattern.forEach(function(){e.blocks.push(2)})},getISOFormatTime:function(){var e=this,t=e.time;return t[2]?e.addLeadingZero(t[0])+":"+e.addLeadingZero(t[1])+":"+e.addLeadingZero(t[2]):""},getBlocks:function(){return this.blocks},getTimeFormatOptions:function(){var e=this;return"12"===String(e.timeFormat)?{maxHourFirstDigit:1,maxHours:12,maxMinutesFirstDigit:5,maxMinutes:60}:{maxHourFirstDigit:2,maxHours:23,maxMinutesFirstDigit:5,maxMinutes:60}},getValidatedTime:function(e){var t=this,r="";e=e.replace(/[^\d]/g,"");var i=t.getTimeFormatOptions();return t.blocks.forEach(function(n,a){if(e.length>0){var o=e.slice(0,n),l=o.slice(0,1),s=e.slice(n);switch(t.timePattern[a]){case"h":parseInt(l,10)>i.maxHourFirstDigit?o="0"+l:parseInt(o,10)>i.maxHours&&(o=i.maxHours+"");break;case"m":case"s":parseInt(l,10)>i.maxMinutesFirstDigit?o="0"+l:parseInt(o,10)>i.maxMinutes&&(o=i.maxMinutes+"")}r+=o,e=s}}),this.getFixedTimeString(r)},getFixedTimeString:function(e){var t,r,i,n=this,a=n.timePattern,o=[],l=0,s=0,c=0,u=0,d=0,m=0;return 6===e.length&&(a.forEach(function(e,t){switch(e){case"s":l=2*t;break;case"m":s=2*t;break;case"h":c=2*t}}),m=c,d=s,u=l,t=parseInt(e.slice(u,u+2),10),r=parseInt(e.slice(d,d+2),10),i=parseInt(e.slice(m,m+2),10),o=this.getFixedTime(i,r,t)),4===e.length&&n.timePattern.indexOf("s")<0&&(a.forEach(function(e,t){switch(e){case"m":s=2*t;break;case"h":c=2*t}}),m=c,d=s,t=0,r=parseInt(e.slice(d,d+2),10),i=parseInt(e.slice(m,m+2),10),o=this.getFixedTime(i,r,t)),n.time=o,0===o.length?e:a.reduce(function(e,t){switch(t){case"s":return e+n.addLeadingZero(o[2]);case"m":return e+n.addLeadingZero(o[1]);case"h":return e+n.addLeadingZero(o[0])}},"")},getFixedTime:function(e,t,r){return r=Math.min(parseInt(r||0,10),60),t=Math.min(t,60),e=Math.min(e,60),[e,t,r]},addLeadingZero:function(e){return(e<10?"0":"")+e}},e.exports=r},function(e,t){"use strict";var r=function(e,t){var r=this;r.delimiter=t||""===t?t:" ",r.delimiterRE=t?new RegExp("\\"+t,"g"):"",r.formatter=e};r.prototype={setFormatter:function(e){this.formatter=e},format:function(e){var t=this;t.formatter.clear(),e=e.replace(/[^\d+]/g,""),e=e.replace(/^\+/,"B").replace(/\+/g,"").replace("B","+"),e=e.replace(t.delimiterRE,"");for(var r,i="",n=!1,a=0,o=e.length;a<o;a++)r=t.formatter.inputDigit(e.charAt(a)),/[\s()-]/g.test(r)?(i=r,n=!0):n||(i=r);return i=i.replace(/[()]/g,""),i=i.replace(/[\s-]/g,t.delimiter)}},e.exports=r},function(e,t){"use strict";var r={blocks:{uatp:[4,5,6],amex:[4,6,5],diners:[4,6,4],discover:[4,4,4,4],mastercard:[4,4,4,4],dankort:[4,4,4,4],instapayment:[4,4,4,4],jcb15:[4,6,5],jcb:[4,4,4,4],maestro:[4,4,4,4],visa:[4,4,4,4],mir:[4,4,4,4],unionPay:[4,4,4,4],general:[4,4,4,4]},re:{uatp:/^(?!1800)1\d{0,14}/,amex:/^3[47]\d{0,13}/,discover:/^(?:6011|65\d{0,2}|64[4-9]\d?)\d{0,12}/,diners:/^3(?:0([0-5]|9)|[689]\d?)\d{0,11}/,mastercard:/^(5[1-5]\d{0,2}|22[2-9]\d{0,1}|2[3-7]\d{0,2})\d{0,12}/,dankort:/^(5019|4175|4571)\d{0,12}/,instapayment:/^63[7-9]\d{0,13}/,jcb15:/^(?:2131|1800)\d{0,11}/,jcb:/^(?:35\d{0,2})\d{0,12}/,maestro:/^(?:5[0678]\d{0,2}|6304|67\d{0,2})\d{0,12}/,mir:/^220[0-4]\d{0,12}/,visa:/^4\d{0,15}/,unionPay:/^62\d{0,14}/},getStrictBlocks:function(e){var t=e.reduce(function(e,t){return e+t},0);return e.concat(19-t)},getInfo:function(e,t){var i=r.blocks,n=r.re;t=!!t;for(var a in n)if(n[a].test(e)){var o=i[a];return{type:a,blocks:t?this.getStrictBlocks(o):o}}return{type:"unknown",blocks:t?this.getStrictBlocks(i.general):i.general}}};e.exports=r},function(e,t){"use strict";var r={noop:function(){},strip:function(e,t){return e.replace(t,"")},getPostDelimiter:function(e,t,r){if(0===r.length)return e.slice(-t.length)===t?t:"";var i="";return r.forEach(function(t){e.slice(-t.length)===t&&(i=t)}),i},getDelimiterREByDelimiter:function(e){return new RegExp(e.replace(/([.?*+^$[\]\\(){}|-])/g,"\\$1"),"g")},getNextCursorPosition:function(e,t,r,i,n){return t.length===e?r.length:e+this.getPositionOffset(e,t,r,i,n)},getPositionOffset:function(e,t,r,i,n){var a,o,l;return a=this.stripDelimiters(t.slice(0,e),i,n),o=this.stripDelimiters(r.slice(0,e),i,n),l=a.length-o.length,0!==l?l/Math.abs(l):0},stripDelimiters:function(e,t,r){var i=this;if(0===r.length){var n=t?i.getDelimiterREByDelimiter(t):"";return e.replace(n,"")}return r.forEach(function(t){t.split("").forEach(function(t){e=e.replace(i.getDelimiterREByDelimiter(t),"")})}),e},headStr:function(e,t){return e.slice(0,t)},getMaxLength:function(e){return e.reduce(function(e,t){return e+t},0)},getPrefixStrippedValue:function(e,t,r,i,n,a,o){if(0===r)return e;if(i.slice(0,r)!==t)return o&&!i&&e?e:"";var l=this.stripDelimiters(i,n,a);return e.slice(0,r)!==t?l.slice(r):e.slice(r)},getFirstDiffIndex:function(e,t){for(var r=0;e.charAt(r)===t.charAt(r);)if(""===e.charAt(r++))return-1;return r},getFormattedValue:function(e,t,r,i,n,a){var o,l="",s=n.length>0;return 0===r?e:(t.forEach(function(t,c){if(e.length>0){var u=e.slice(0,t),d=e.slice(t);o=s?n[a?c-1:c]||o:i,a?(c>0&&(l+=o),l+=u):(l+=u,u.length===t&&c<r-1&&(l+=o)),e=d}}),l)},fixPrefixCursor:function(e,t,r,i){if(e){var n=e.value,a=r||i[0]||" ";if(e.setSelectionRange&&t&&!(t.length+a.length<n.length)){var o=2*n.length;setTimeout(function(){e.setSelectionRange(o,o)},1)}}},checkFullSelection:function(e){try{var t=window.getSelection()||document.getSelection()||{};return t.toString().length===e.length}catch(r){}return!1},setSelection:function(e,t,r){if(e===this.getActiveElement(r)&&!(e&&e.value.length<=t))if(e.createTextRange){var i=e.createTextRange();i.move("character",t),i.select()}else try{e.setSelectionRange(t,t)}catch(n){console.warn("The input element type does not support selection")}},getActiveElement:function(e){var t=e.activeElement;return t&&t.shadowRoot?this.getActiveElement(t.shadowRoot):t},isAndroid:function(){return navigator&&/android/i.test(navigator.userAgent)},isAndroidBackspaceKeydown:function(e,t){return!!(this.isAndroid()&&e&&t)&&t===e.slice(0,-1)}};e.exports=r},function(e,t){(function(t){"use strict";var r={assign:function(e,r){return e=e||{},r=r||{},e.creditCard=!!r.creditCard,e.creditCardStrictMode=!!r.creditCardStrictMode,e.creditCardType="",e.onCreditCardTypeChanged=r.onCreditCardTypeChanged||function(){},e.phone=!!r.phone,e.phoneRegionCode=r.phoneRegionCode||"AU",e.phoneFormatter={},e.time=!!r.time,e.timePattern=r.timePattern||["h","m","s"],e.timeFormat=r.timeFormat||"24",e.timeFormatter={},e.date=!!r.date,e.datePattern=r.datePattern||["d","m","Y"],e.dateMin=r.dateMin||"",e.dateMax=r.dateMax||"",e.dateFormatter={},e.numeral=!!r.numeral,e.numeralIntegerScale=r.numeralIntegerScale>0?r.numeralIntegerScale:0,e.numeralDecimalScale=r.numeralDecimalScale>=0?r.numeralDecimalScale:2,e.numeralDecimalMark=r.numeralDecimalMark||".",e.numeralThousandsGroupStyle=r.numeralThousandsGroupStyle||"thousand",e.numeralPositiveOnly=!!r.numeralPositiveOnly,e.stripLeadingZeroes=r.stripLeadingZeroes!==!1,e.signBeforePrefix=!!r.signBeforePrefix,e.numericOnly=e.creditCard||e.date||!!r.numericOnly,e.uppercase=!!r.uppercase,e.lowercase=!!r.lowercase,e.prefix=e.creditCard||e.date?"":r.prefix||"",e.noImmediatePrefix=!!r.noImmediatePrefix,e.prefixLength=e.prefix.length,e.rawValueTrimPrefix=!!r.rawValueTrimPrefix,e.copyDelimiter=!!r.copyDelimiter,e.initValue=void 0!==r.initValue&&null!==r.initValue?r.initValue.toString():"",e.delimiter=r.delimiter||""===r.delimiter?r.delimiter:r.date?"/":r.time?":":r.numeral?",":(r.phone," "),e.delimiterLength=e.delimiter.length,e.delimiterLazyShow=!!r.delimiterLazyShow,e.delimiters=r.delimiters||[],e.blocks=r.blocks||[],e.blocksLength=e.blocks.length,e.root="object"==typeof t&&t?t:window,e.document=r.document||e.root.document,e.maxLength=0,e.backspace=!1,e.result="",e.onValueChanged=r.onValueChanged||function(){},e}};e.exports=r}).call(t,function(){return this}())}])});
