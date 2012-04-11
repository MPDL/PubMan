/*
 *
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License"). You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at license/ESCIDOC.LICENSE
 * or http://www.escidoc.de/license.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at license/ESCIDOC.LICENSE.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */
/*
 * Copyright 2006-2011 Fachinformationszentrum Karlsruhe Gesellschaft
 * für wissenschaftlich-technische Information mbH and Max-Planck-
 * Gesellschaft zur Förderung der Wissenschaft e.V.
 * All rights reserved. Use is subject to license terms.
 */
function addItemListFunctions(){
    $('.itemList').each(function(i, ele){
        $(ele).find('.mediumView').each(function(j, elem){
            $(elem).hide();
        });
        $(ele).find('.collapse').each(function(j, elem){
            $(elem).hide();
        });
        $(ele).find('.expand').each(function(j, elem){
            $(elem).show();
        });
        $(ele).find('.collapseTriangle').each(function(j, elem){
            $(elem).hide();
        });
        $(ele).find('.expandTriangle').each(function(j, elem){
            $(elem).show();
        });
        $(ele).find('.listItem').hover(function(){
            $(this).addClass('listBackground');
        }, function(){
            $(this).removeClass('listBackground');
        });
    });
// Openration of the select menu for checkboxes 
// Start with event on document to close the select menu on click elswhere    
    $('html').click(function(){
//        $('.selectMenu').hide();
    });
    
    $('.selectMenu').click(function(evt){
    	evt.preventDefault();
    	evt.stopPropagation();
    	evt.stopImmediatePropagation();
    });
    
    function hideElement(element) {
    	element.hide(100);
    }
    
    $('.checkBoxSelectButton').click(function(evt){
    	evt.preventDefault();
    	evt.stopPropagation();
    	evt.stopImmediatePropagation();
    	
    	$('body').unbind("click");
    	$('body').unbind("keydown");
    	
    	var cbsButtonPosition = $(this).position();
    	
    	var slctMenu = $(this).siblings('.selectMenu');
    	$('body').one("click", function(evt) {
    		hideElement(slctMenu);
    	});
    	$('body').one('keydown', function(evt){
			if (Number(evt.which) === 27) {	//check the key-number for number of escape
				hideElement(slctMenu);
			}
		});
    	slctMenu.toggle(100, function(){
    		if ($(slctMenu).is(':visible')) {
    			$(slctMenu).css("left", cbsButtonPosition.left + 10);
//    			$(slctMenu).css("top", cbsButtonPosition.top - 2);
        	}
    	});
    	
//    	$(this).siblings('.selectMenu').toggle(100);
    });
    
// Select options    
    var tog = '';
    $('.listHeader').find('.allCheckBox').click(function(){
    	$('.itemList').find("input[type=checkbox]").attr("checked", !tog);
    	tog = !tog;
    });
//	$(this).parents('.selectMenu').hide();
    hideElement($(this).parents('.selectMenu'));

    $('.listHeader').find('.selectAll').click(function(){
        $('.itemList').find('input[type=checkbox]').attr('checked', true);
    });
//	$(this).parents('.selectMenu').hide();
    hideElement($(this).parents('.selectMenu'));

    $('.selectMenu').find('.toggleAll').click(function(){
        $('.listItem').find('input[type=checkbox]').click();
    });
//	$(this).parents('.selectMenu').hide();
    hideElement($(this).parents('.selectMenu'));

    $('.selectMenu').find('.selectNone').click(function(){
        $(this).parents('.itemList').find('.itemCheckBox').attr('checked', false);
    });
//	$(this).parents('.selectMenu').hide();
    hideElement($(this).parents('.selectMenu'));
    
    $('.selectMenu').find('a').each(function(i, elem){
        $(elem).click(function(){
//            $(this).parents('.selectMenu').hide()
        	hideElement($(this).parents('.selectMenu'));
        });
    });
    
    $('.headerSwitchView').find('.expandTriangle').click(function(){
        $(this).hide();
        $(this).siblings('.collapseTriangle').show();
        $(this).parents('.itemList').find('.listItem').find('.expandTriangle:visible').each(function(i, elem){
            $(elem).trigger('click');
        });
    });
    
    $('.headerSwitchView').find('.collapseTriangle').click(function(){
        $(this).hide();
        $(this).siblings('.expandTriangle').show();
        $(this).parents('.itemList').find('.listItem').find('.collapseTriangle:visible').each(function(i, elem){
            $(elem).trigger('click');
        });
    });
    
    $('.shortView').find('.expandTriangle').each(function(i, ele){
        $(ele).click(function(){
            $(this).hide();
            $(this).siblings('.collapseTriangle').show();
            var parentElement = $(this).parents('.listItem');
            $(parentElement).children('.mediumView').slideToggle('normal', function(){
                if (($(parentElement).find('.itemHeader').find('.expandTriangle:visible').length) ==
                0) {
                    $(parentElement).find('.headerSwitchView').find('.expandTriangle').hide();
                    $(parentElement).find('.headerSwitchView').find('.collapseTriangle').show();
                }
            });
        })
    });
    
    $('.shortView').find('.collapseTriangle').each(function(i, ele){
        $(ele).click(function(){
            $(this).hide();
            $(this).siblings('.expandTriangle').show();
            var parentElement = $(this).parents('.listItem');
            $(parentElement).children('.mediumView').slideToggle('normal', function(){
                if (($(parentElement).find('.itemHeader').find('.collapseTriangle:visible').length) ==
                0) {
                    $(parentElement).find('.headerSwitchView').find('.expandTriangle').show();
                    $(parentElement).find('.headerSwitchView').find('.collapseTriangle').hide();
                }
            });
        })
    });
    
}

function installItemList(){
    /* ADD LISTENERS TO CHANGED DOM */
    addItemListFunctions();
}











