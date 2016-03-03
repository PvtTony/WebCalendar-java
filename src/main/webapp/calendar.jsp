<%--
  Created by IntelliJ IDEA.
  User: yst
  Date: 2016/2/20
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar Page</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="components/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="components/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/calendar.css">
</head>
<body>
<%--<p>Login Successful.</p>
<p>UserID:${usrID}</p>
<p>NickName:${usrNickname}</p>
<p>Email:${usrEmail}</p>
<p>Registered Date:${usrRegistered}</p>
<p>Json:${EventJson}</p>--%>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome ${usrNickname}!</h1>

    </div>

    <div class="page-header">

        <div class="pull-right form-inline">
            <div class="btn-group">
                <button class="btn btn-primary" data-calendar-nav="prev"><< Prev</button>
                <button class="btn btn-default" data-calendar-nav="today">Today</button>
                <button class="btn btn-primary" data-calendar-nav="next">Next >></button>
            </div>
            <div class="btn-group">
                <button class="btn btn-warning" data-calendar-view="year">Year</button>
                <button class="btn btn-warning active" data-calendar-view="month">Month</button>
                <button class="btn btn-warning" data-calendar-view="week">Week</button>
                <button class="btn btn-warning" data-calendar-view="day">Day</button>
            </div>
        </div>

        <h3></h3>

    </div>

    <div class="row">
        <div id="calendar"></div>
    </div>

    <div class="modal fade" id="events-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Event</h4>
                </div>
                <div class="modal-body" style="height: 400px">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="components/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="components/underscore/underscore-min.js"></script>
    <script type="text/javascript" src="components/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="components/jstimezonedetect/jstz.min.js"></script>
    <script type="text/javascript" src="js/language/nl-NL.js"></script>
    <script type="text/javascript" src="js/language/fr-FR.js"></script>
    <script type="text/javascript" src="js/language/de-DE.js"></script>
    <script type="text/javascript" src="js/language/el-GR.js"></script>
    <script type="text/javascript" src="js/language/it-IT.js"></script>
    <script type="text/javascript" src="js/language/pl-PL.js"></script>
    <script type="text/javascript" src="js/language/pt-BR.js"></script>
    <script type="text/javascript" src="js/language/ro-RO.js"></script>
    <script type="text/javascript" src="js/language/es-MX.js"></script>
    <script type="text/javascript" src="js/language/es-ES.js"></script>
    <script type="text/javascript" src="js/language/ru-RU.js"></script>
    <script type="text/javascript" src="js/language/sv-SE.js"></script>
    <script type="text/javascript" src="js/language/cs-CZ.js"></script>
    <script type="text/javascript" src="js/language/ko-KR.js"></script>
    <script type="text/javascript" src="js/calendar.js"></script>
    <!--<script type="text/javascript" src="js/app.js"></script>-->
    <script>
        (function ($) {

            "use strict";

            var options = {
                events_source: ${EventJson},
                view: 'month',
                tmpl_path: 'tmpls/',
                tmpl_cache: false,
                onAfterEventsLoad: function (events) {
                    if (!events) {
                        return;
                    }
                    var list = $('#eventlist');
                    list.html('');

                    $.each(events, function (key, val) {
                        $(document.createElement('li'))
                                .html('<a href="' + val.url + '">' + val.title + '</a>')
                                .appendTo(list);
                    });
                },
                onAfterViewLoad: function (view) {
                    $('.page-header h3').text(this.getTitle());
                    $('.btn-group button').removeClass('active');
                    $('button[data-calendar-view="' + view + '"]').addClass('active');
                },
                classes: {
                    months: {
                        general: 'label'
                    }
                }
            };

            var calendar = $('#calendar').calendar(options);

            $('.btn-group button[data-calendar-nav]').each(function () {
                var $this = $(this);
                $this.click(function () {
                    calendar.navigate($this.data('calendar-nav'));
                });
            });

            $('.btn-group button[data-calendar-view]').each(function () {
                var $this = $(this);
                $this.click(function () {
                    calendar.view($this.data('calendar-view'));
                });
            });

            $('#first_day').change(function () {
                var value = $(this).val();
                value = value.length ? parseInt(value) : null;
                calendar.setOptions({first_day: value});
                calendar.view();
            });

            /*$('#language').change(function () {
             calendar.setLanguage($(this).val());
             calendar.view();
             });*/

            /*$('#events-in-modal').change(function () {
             var val = $(this).is(':checked') ? $(this).val() : null;
             calendar.setOptions({modal: val});
             });*/
            /*$('#events-modal .modal-header, #events-modal .modal-footer').click(function (e) {
             //e.preventDefault();
             //e.stopPropagation();
             });*/
        }(jQuery));
    </script>
</div>
</body>
</html>
