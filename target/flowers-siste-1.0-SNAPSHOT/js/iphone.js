/**
 * Created by Vlad on 30.07.2017.
 */
$(function(){
    var slider = $('#slider');
    var sliderWrap = $('#slider ul');
    var sliderImg = $('#slider ul li');
    var prevBtm = $('#sliderPrev');
    var nextBtm = $('#sliderNext');
    var length = sliderImg.length;
    var width = sliderImg.width();

    sliderWrap.width(width*length);
    $('#slider ul li:last-child').prependTo('#slider ul');
    sliderWrap.css('margin-left', - width);

    nextBtm.on('click', function(){
        sliderWrap.animate({
            'margin-left': '-=' + width
        }, 500, function() {
            $('#slider ul li:first-child').appendTo('#slider ul');
            sliderWrap.css('margin-left', - width);
        });
        return false;
    });

    prevBtm.on('click', function(){
        sliderWrap.animate({
            'margin-left': '+=' + width
        }, 500, function() {
            $('#slider ul li:last-child').prependTo('#slider ul');
            sliderWrap.css('margin-left', - width);
        });
        return false;
    });

});