package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.*;
import com.codesquad.issuetracker.ragdoll.dto.request.*;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.IssueService_Ragdoll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ragdoll")
public class IssueController_Ragdoll {

    private final IssueService_Ragdoll issueService;

    public IssueController_Ragdoll(IssueService_Ragdoll issueService) {
        this.issueService = issueService;
    }

//    @GetMapping("/issues")
//    public ResponseEntity<ApiResponse<ListOfIssuesDto>> list() {
//        return new ResponseEntity(ApiResponse.OK(issueService.findAllIssues()), HttpStatus.OK);
//    }

    @PostMapping("/issues")
    public ResponseEntity<ApiResponse<String>> submit(@RequestBody SubmitNewIssueRequestDto submitNewIssueRequestDto) {
        return new ResponseEntity(ApiResponse.CREATED(issueService.submitNewIssue(submitNewIssueRequestDto)), HttpStatus.CREATED);
    }

    @GetMapping("/issues")
    public ResponseEntity<ApiResponse<ListOfIssuesDto>> filter(@ModelAttribute FilterParameters filterParameters) {
        return new ResponseEntity(ApiResponse.OK(issueService.findIssuesByFilterParameters(filterParameters)), HttpStatus.OK);
    }

    @GetMapping("/issues/{issueId}")
    public ResponseEntity<ApiResponse<DetailedInformationOfIssueDto>> showDetails(@PathVariable Long issueId) {
        return new ResponseEntity(ApiResponse.OK(issueService.showIssueDetails(issueId)), HttpStatus.OK);
    }

    @PatchMapping("/issues/{issueId}/title")
    public ResponseEntity<ApiResponse<String>> modifyTitle(@PathVariable Long issueId, @RequestBody UpdateIssueTitleRequestDto updateIssueTitleRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.modifyIssueTitle(issueId, updateIssueTitleRequestDto)), HttpStatus.OK);
    }

    @PatchMapping("/issues/{issueId}/mark")
    public ResponseEntity<ApiResponse<String>> modifyIssueStatus(@PathVariable Long issueId, @RequestBody UpdateIssueStatusRequestDto updateIssueStatusRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.modifyIssueStatus(issueId, updateIssueStatusRequestDto)), HttpStatus.OK);
    }

    @PutMapping("/issues/{issueId}/assignees")
    public ResponseEntity<ApiResponse<String>> updateAssignees(@PathVariable Long issueId, @RequestBody UpdateAssigneesRequestDto updateAssigneesRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.updateAssignees(issueId, updateAssigneesRequestDto)), HttpStatus.OK);
    }

    @PutMapping("/issues/{issueId}/labels")
    public ResponseEntity<ApiResponse<String>> updateLabels(@PathVariable Long issueId, @RequestBody UpdateLabelsRequestDto updateLabelsRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.updateLabels(issueId, updateLabelsRequestDto)), HttpStatus.OK);
    }

    @PatchMapping("/issues/{issueId}/milestones")
    public ResponseEntity<ApiResponse<String>> updateMilestone(@PathVariable Long issueId, @RequestBody UpdateMilestoneRequestDto updateMilestoneRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.updateRelatedMilestone(issueId, updateMilestoneRequestDto)), HttpStatus.OK);
    }

    @PostMapping("/issues/{issueId}/comments")
    public ResponseEntity<ApiResponse<String>> submitComment(@PathVariable Long issueId, @RequestBody CommentsRequestDto commentsRequestDto) {
        return new ResponseEntity(ApiResponse.CREATED(issueService.submitNewComment(issueId, commentsRequestDto)), HttpStatus.CREATED);
    }

    @PatchMapping("/issues/{issueId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<String>> updateComment(@PathVariable Long issueId, @PathVariable Long commentId, @RequestBody CommentsRequestDto commentsRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.updateComment(issueId, commentId, commentsRequestDto)), HttpStatus.OK);
    }
}
