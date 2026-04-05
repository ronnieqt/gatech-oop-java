param(
    [switch]$Run
)

$repoRoot = Split-Path $PSScriptRoot -Parent
$files = Get-ChildItem -Path $repoRoot -Recurse -Filter "*.class"

if ($files.Count -eq 0) {
    Write-Host "No .class files found."
} elseif ($Run) {
    $files | Remove-Item -Force
    Write-Host "Deleted $($files.Count) .class file(s)."
} else {
    Write-Host "[Dry-run] Would delete $($files.Count) .class file(s):"
    $files | ForEach-Object { Write-Host "  $($_.FullName)" }
    Write-Host "Re-run with -Run to apply changes."
}
