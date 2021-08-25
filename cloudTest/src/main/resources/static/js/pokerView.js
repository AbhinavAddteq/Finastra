// To show issue details on sidebar
function triggerDetails(issueKey) {
    //    AP.jira.openIssueDialog(issueKey,
    //         function(){
    //           console.log('Issue Closed!');
    //         }
    //    );
    // Display a nice green flag using the Flags JavaScript API.
    var flag = AP.flag.create({
        body: 'You are now estimating issue ' + issueKey,
        type: 'info',
        close: 'auto'
    });

    AP.request('/rest/api/2/issue/' + issueKey)
    .then(data => viewDetails(data.body))
    .catch(e => console.log(e.err));
}

function viewDetails(issueData) {
    var issueDetailsSideBar = document.querySelector('#issueDetails');
    issueDetailsSideBar.style.display = 'table-cell';

    var issue = JSON.parse(issueData);
    console.log(issue);

    var assignee = '';
    var reporter = '';
    var description = '';

    if (issue.fields) {
        if (issue.fields.assignee) {
            assignee = issue.fields.assignee.displayName;
        }

        if (issue.fields.reporter) {
            reporter = issue.fields.reporter.displayName;
        }

        if (issue.fields.description) {
            description = issue.fields.description;
        }
    }
    var detailsHtml = `

        <table class="aui aui-table-list">
            <h4>${issue.key}</h4>
            <tbody>
                <tr>
                    <td>Status</td>
                    <td>${issue.fields.status.name}</td>
                </tr>
                <tr>
                    <td>Assignee</td>
                    <td>${assignee}</td>
                </tr>
                <tr>
                    <td>Reporter</td>
                    <td>${reporter}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${description}</td>
                </tr>
            </tbody>
        </table>
    `
    var issueDetailsSideBarContent = document.querySelector('#issueDetailsContent');
    issueDetailsSideBarContent.innerHTML = detailsHtml;
}

function issueDetailsClose() {
    var issueDetailsSideBar = document.querySelector('#issueDetails');
    issueDetailsSideBar.style.display = 'none';
}

//-------End of To show issue details on sidebar-----------------------------

// Trigger selected issue details
function triggerSelectedIssue(issueKey) {
    var url = '/viewPoker/selected?issueKey=' + issueKey + '&jwt=' + document.querySelector('#atlassianJwt').value;
    $('#selectedIssue').load(url);
}
//------------end of Trigger selected issue details-------------------------------------------

$(document).ready(function () {

    var JWT_TOKEN = document.querySelector('#atlassianJwt').value;

    // JQL Editor Snippet
    AP.jira.initJQLEditor();

    var jqlQueryInput = document.querySelector('#jqlQueryInput');

    jqlQueryInput.addEventListener("click", function() {
        var currentJQL = this.value ? this.value : 'assignee IN (currentUser()) || reporter = currentUser()';
        var options = {
          descriptionText: 'Please note, only issues associated with the current board will be displayed when you submit.',
          jql: currentJQL
        };

        AP.jira.showJQLEditor(options, callback);
    });

    var callback = function(obj) {
        $('#unEstimatedButton').removeClass('aui-button-primary');
        $('#recentlyUpdatedButton').removeClass('aui-button-primary');

        jqlQueryInput.value = obj.jql;
        var boardId = jqlQueryInput.getAttribute('data-board-id');
        var jql = encodeURIComponent(obj.jql);
        var url = '/viewPoker/jql?jql=' + jql + '&boardId=' + boardId + '&jwt=' + JWT_TOKEN;

        $('#selectedIssue').empty();
        $('#boardIssues').load(url);
    };

    //--------end of JQL Editor Snippet---------------------------------------------------------

    // Unestimated issues filter
    var unEstimatedButton = document.querySelector('#unEstimatedButton');

    var unEstimated = function() {
        $(this).addClass('aui-button-primary');
        $('#recentlyUpdatedButton').removeClass('aui-button-primary');

        //var unEstimatedJQL = 'originalEstimate is EMPTY AND ' + jqlQueryInput.value;
        var unEstimatedJQL = 'originalEstimate is EMPTY';
        var boardId = jqlQueryInput.getAttribute('data-board-id');
        var jql = encodeURIComponent(unEstimatedJQL);
        var url = '/viewPoker/jql?jql=' + jql + '&boardId=' + boardId + '&jwt=' + JWT_TOKEN;

        $('#selectedIssue').empty();

        $('#boardIssues').load(url);
    }
    unEstimatedButton.addEventListener("click", unEstimated);
    //-----------------end of Unestimated issues filter----------------------------------------------

    // Single issues filter
    var singleIssueSelect = document.querySelector('#singleIssue');

    singleIssueSelect.addEventListener("change", function() {
        $('#unEstimatedButton').removeClass('aui-button-primary');
        $('#recentlyUpdatedButton').removeClass('aui-button-primary');

        var currentJQL = 'issueKey=' + this.value;
        var boardId = jqlQueryInput.getAttribute('data-board-id');
        var jql = encodeURIComponent(currentJQL);
        var url = '/viewPoker/jql?jql=' + jql + '&boardId=' + boardId + '&jwt=' + JWT_TOKEN;

        $('#selectedIssue').empty();

        $('#boardIssues').load(url);
    });
    //-----------------end of Single issues filter----------------------------------------------

    // Recently updated issues filter
    var recentlyUpdatedButton = document.querySelector('#recentlyUpdatedButton');

    var recentlyUpdated = function() {

        $(this).addClass('aui-button-primary');
        $('#unEstimatedButton').removeClass('aui-button-primary');

        //var recentlyUpdatedJQL =  + 'updated = startOfMonth() AND ' + jqlQueryInput.value;
        var recentlyUpdatedJQL = 'updated = startOfMonth()';
        var boardId = jqlQueryInput.getAttribute('data-board-id');
        var jql = encodeURIComponent(recentlyUpdatedJQL);
        var url = '/viewPoker/jql?jql=' + jql + '&boardId=' + boardId + '&jwt=' + JWT_TOKEN;

        $('#selectedIssue').empty();

        $('#boardIssues').load(url);
    }
    recentlyUpdatedButton.addEventListener("click", recentlyUpdated);
    //-----------------end of Recently updated issues filter----------------------------------------------

    // refreshButton snippet
    var refreshButton = document.querySelector('#refreshButton');
    var refreshed = function() {
        $('#unEstimatedButton').removeClass('aui-button-primary');
        $('#recentlyUpdatedButton').removeClass('aui-button-primary');

        var refreshedJQL = jqlQueryInput.value;
        var boardId = jqlQueryInput.getAttribute('data-board-id');
        var jql = encodeURIComponent(refreshedJQL);
        var url = '/viewPoker/jql?jql=' + jql + '&boardId=' + boardId + '&jwt=' + JWT_TOKEN;

        $('#selectedIssue').empty();

        $('#boardIssues').load(url);
    }
    refreshButton.addEventListener("click", refreshed);
    //----------end of refreshButton snippet--------------------------------------------------------
});